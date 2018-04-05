package matchings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bayonet.distributions.Random;
import blang.core.LogScaleFactor;
import blang.distributions.Generators;
import blang.mcmc.ConnectedFactor;
import blang.mcmc.SampledVariable;
import blang.mcmc.Sampler;
import briefj.collections.UnorderedPair;

/**
 * Each time a Permutation is encountered in a Blang model, 
 * this sampler will be instantiated. 
 */
public class PermutationSampler implements Sampler {
  /**
   * This field will be populated automatically with the 
   * permutation being sampled. 
   */
  @SampledVariable Permutation permutation;
  /**
   * This will contain all the elements of the prior or likelihood 
   * (collectively, factors), that depend on the permutation being 
   * resampled. 
   */
  @ConnectedFactor List<LogScaleFactor> numericFactors;

  @Override
  public void execute(Random rand) {

	  // Obtain the current connected vertices.
	  List<Integer> currentState = permutation.getConnections();
      double currentLogDensity = logDensity();
      ArrayList<Integer> deepcurrentState = new ArrayList<Integer>(currentState);
      
      // The algorithm randomly select a pair of vertices each time and swap their connections.
      UnorderedPair<Integer,Integer> SwapPairs = Generators.distinctPair(rand,currentState.size());
      Collections.swap(permutation.getConnections(), SwapPairs.getFirst(), SwapPairs.getSecond());
      
	  double nextLogDensity = logDensity();
	  double ratio = Math.exp(nextLogDensity - currentLogDensity);
	  boolean u = Generators.bernoulli(rand, Math.min(1.0, ratio));
	  if(!u) {
		  for (int i = 0; i < deepcurrentState.size(); i ++ ) {
			  permutation.getConnections().set(i, deepcurrentState.get(i));
		  }
	  }
    
  }
  
  private double logDensity() {
    double sum = 0.0;
    for (LogScaleFactor f : numericFactors)
      sum += f.logDensity();
    return sum;
  }
}
