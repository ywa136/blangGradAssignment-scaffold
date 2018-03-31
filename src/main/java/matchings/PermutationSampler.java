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
    // Fill this.  
//	    
//	  System.out.println("previous state");
//	  System.out.println("-----------------------------------------------");
//	  double currentDensity = logDensity();
//    List<Integer> currentConnections = permutation.getConnections();
//    
//    ArrayList<Integer> nextState = new ArrayList<Integer>(currentConnections);
//	  System.out.println(nextState);
//      
//	  System.out.println(currentDensity);
//		 permutation.sampleUniform(rand);
//		 System.out.println("current state");
//		 System.out.println("-----------------------------------------------"); 
//		 double newDensity = logDensity();
//
//		 System.out.println(permutation.getConnections());
//		 System.out.println(newDensity); 
	  
//	  permutation.getConnections();
	        
	  	  
	  //	  System.out.println("Current -------------------------------------");
	  //	  double[] probabilities = {0.1,0.1,0.8};
	  	  
	  //	  long n = (long)rand.nextCategorical(probabilities) + 1;
	  //	  Random curRandom = new Random(n);
	  //	  permutation.sampleUniform(curRandom);
//	  System.out.println("Current -------------------------------------");
//	        List<Integer> currentConnections = permutation.getConnections();
//	        System.out.println(currentConnections);
//	        ArrayList<Integer> deepCurrentConnections = new ArrayList<Integer>(currentConnections);
//	        double currentDensity = logDensity();
//	        
//	        permutation.sampleUniform(rand);
//	        List<Integer> newConnections = permutation.getConnections();
//	        
//	  	  double newDensity = logDensity();
////	  	  System.out.println("deepCurrent -------------------------------------");
////	  	  System.out.println(deepCurrentConnections);
//	  	  System.out.println("newConnections -------------------------------------");
//	  	  System.out.println(newConnections);
//	  	  double alpha = Math.min(1, Math.exp(newDensity)/Math.exp(currentDensity));
//	  	  //double alpha = Math.min(1, (newDensity)/(currentDensity));
//	  	 //Random currand = new Random();
//	  	  boolean u = rand.nextBernoulli(alpha);
//	  	  System.out.println("Alpha is");
//	  	  System.out.println(alpha);
//	  	  System.out.println("u is");
//	  	  System.out.println(u);
//  	  
//		  if (u) {
//		 		 // permutation.setConnections(permutation.getConnection);
//		 		  for (int i = 0; i < newConnections.size(); i ++ ) {
//					  deepCurrentConnections.set(i, newConnections.get(i));
//					  permutation.getConnections().set(i, newConnections.get(i));
//		 			
//		 		  }
//				  System.out.println("The new sampled one is");
//				  System.out.println("We decide to pick the new one");
//		 		  System.out.println(permutation.getConnections());
//			  } else {
//				  for (int i = 0; i < deepCurrentConnections.size(); i ++ ) {
//					  permutation.getConnections().set(i, deepCurrentConnections.get(i));
//					
//				  }
//				  System.out.println("We decide to stick with the old one");
//				  System.out.println(permutation.getConnections());
//		 	  }
	  List<Integer> conBefore = permutation.getConnections();
      final double logBefore = logDensity();
      ArrayList<Integer> deepconBefore = new ArrayList<Integer>(conBefore);
      permutation.sampleUniform(rand);
//      List<Integer> conAfter = permutation.getConnections();
	  final double logAfter = logDensity();
	  final double ratio = Math.exp(logAfter - logBefore);
	  boolean u = Generators.bernoulli(rand, Math.min(1.0, ratio));
	  if(!u) {
		  for (int i = 0; i < deepconBefore.size(); i ++ ) {
			  permutation.getConnections().set(i, deepconBefore.get(i));
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
