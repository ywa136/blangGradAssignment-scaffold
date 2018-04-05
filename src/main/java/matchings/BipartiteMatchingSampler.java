package matchings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import bayonet.distributions.Multinomial;
import bayonet.distributions.Random;
import blang.core.LogScaleFactor;
import blang.distributions.Generators;
import blang.mcmc.ConnectedFactor;
import blang.mcmc.SampledVariable;
import blang.mcmc.Sampler;

import static java.util.Collections.sort;
import static java.util.Collections.shuffle;
import briefj.collections.UnorderedPair;


/**
 * Each time a Permutation is encountered in a Blang model, 
 * this sampler will be instantiated. 
 */
public class BipartiteMatchingSampler implements Sampler {
  /**
   * This field will be populated automatically with the 
   * permutation being sampled. 
   */
  @SampledVariable BipartiteMatching matching;
  /**
   * This will contain all the elements of the prior or likelihood 
   * (collectively, factors), that depend on the permutation being 
   * resampled. 
   */
  @ConnectedFactor List<LogScaleFactor> numericFactors;
  
  @Override
  public void execute(Random rand) {
    // Fill this. 
//	  List<Integer> conBefore = matching.getConnections();
//      final double logBefore = logDensity();
//      ArrayList<Integer> deepconBefore = new ArrayList<Integer>(conBefore);
//      matching.sampleUniform(rand);
//	  final double logAfter = logDensity();
//	  final double ratio = Math.exp(logAfter - logBefore);
//	  boolean u = Generators.bernoulli(rand, Math.min(1.0, ratio));
//	  if(!u) {
//		  for (int i = 0; i < deepconBefore.size(); i ++ ) {
//			  matching.getConnections().set(i, deepconBefore.get(i));
//		  }
//	  }
//	List<Integer> currentState = matching.getConnections();
////	System.out.println("-------------------------------------------------------------------");
////	System.out.println(currentState);
//    final double currentLogDensity = logDensity();
//    ArrayList<Integer> deepcurrentState = new ArrayList<Integer>(currentState);
//    ArrayList<Integer> tmp = new ArrayList<Integer>();
//    
//	for (int i = 0; i < currentState.size(); i ++ ) {
//	    	tmp.add(-1);
//	}
//	for (int i = 0; i < currentState.size(); i ++ ) {
//    		tmp.add(currentState.get(i));
//	}
//    
//    shuffle(tmp,rand);
//    
//    for (int i = 0; i < matching.getConnections().size(); i ++ ) {
//    		matching.getConnections().set(i, tmp.get(i));
//    }
//    
////    System.out.println(matching.getConnections());
////    System.out.println("-------------------------------------------------------------------");
//	  final double proposedLogDensity = logDensity();
//	  final double ratio = Math.exp(proposedLogDensity - currentLogDensity);
//	  boolean u = Generators.bernoulli(rand, Math.min(1.0, ratio));
//	  if(!u) {
//		  for (int i = 0; i < deepcurrentState.size(); i ++ ) {
//			  matching.getConnections().set(i, deepcurrentState.get(i));
//		  }
//	  }
	  
//	  List<Integer> currentState = matching.getConnections();
//	  double currentLogDensity = logDensity();
//      ArrayList<Integer> deepcurrentState = new ArrayList<Integer>(currentState);
//      
////      Arrays.fill(chooseSizeProbabilities, 0.2);
////	  
////      newSize = Generators.categorical(rand, chooseSizeProbabilities);
////      
////      ArrayList<Integer> occupied = new ArrayList<>(5);
////      ArrayList<Integer> newConnections = new ArrayList<>(5);
////      for (int i = 0; i < 5; i++) {
////    	  	occupied.add(i);
////    	  	newConnections.add(i);
////      }
////      
//      UnorderedPair<Integer,Integer> ShufflePairs = Generators.distinctPair(rand,currentState.size());
////      UnorderedPair<Integer,Integer> Shuffle2 = Generators.distinctPair(rand,5);
////      System.out.println(ShufflePairs);
//      int Idx1 = ShufflePairs.getFirst();
//      int Idx2 = ShufflePairs.getSecond();
//      
//      if (matching.getConnections().get(Idx1)==-1 || matching.getConnections().get(Idx2)==-1) {
//	      int randDecision = rand.nextInt(3); 
////	      int randDeletion = rand.nextInt(2);
//	      if (randDecision == SWAP) {
//	    	  	Collections.swap(matching.getConnections(),Idx1,Idx2);
//	      } if (randDecision == DEL) {
//		    	if (matching.getConnections().get(Idx1)!=-1) {matching.getConnections().set(Idx1, -1);}
//		    	if (matching.getConnections().get(Idx2)!=-1) {matching.getConnections().set(Idx2, -1);}
//	      } 
//	      	// ADD case
//	      	else {
////	    	    int addToConnections = rand.nextInt(matching.getConnections().size());
////	    	    
////	    	    while (matching.getConnections().contains(addToConnections)) {
////	    	    		addToConnections = rand.nextInt(matching.getConnections().size());
////	    	    }
////	    	  	if (matching.getConnections().contains(addToConnections)) {
////  	  			if (matching.getConnections().get(Idx1)==-1) {matching.getConnections().set(Idx1, -1);}
////  	  			if (matching.getConnections().get(Idx2)==-1) {matching.getConnections().set(Idx2, -1);}
////	    	  	} 
//	    	  
//	    	  	ArrayList<Integer> leftOvers = new ArrayList<Integer>();
//	    	  	leftOvers.add(-1);
//	    	  	for (int i = 0; i < matching.getConnections().size(); i ++) {
//	    	  		if (! matching.getConnections().contains(i)) {
//	    	  			leftOvers.add(i);
//	    	  		}
//	    	  	}
////	    	  	
	         
//
//	    	  	java.util.Random random = new java.util.Random();
//	    	  	if (matching.getConnections().get(Idx1) < 0) {
//	    	  		int firstChoiceIndex = random.nextInt(leftOvers.size());
//	    	  		int firstChoice = leftOvers.get(firstChoiceIndex);
//	    	  		matching.getConnections().set(Idx1, firstChoice);
//	    	  		// remove from the arraylist
//	    	  		leftOvers.remove(firstChoiceIndex);
//	    	  		
//	    	  		
//	    	  	}
//	    	  	if (matching.getConnections().get(Idx2) < 0) {
//	    	  		int secondChoiceIndex = random.nextInt(leftOvers.size());
//	    	  		int secondChoice = leftOvers.get(secondChoiceIndex);
//	    	  		matching.getConnections().set(Idx2, secondChoice);
//	    	  		// remove from the arraylist
//	    	  		//leftOvers.remove(secondChoiceIndex);
//	    	  	}
//	    	  	
//	    	  	
//	      }	
//      } else {
//	      int randDecision = rand.nextInt(3); 
//	      int randDeletion = rand.nextInt(2);
//	      if (randDecision==0) {
//	    	  	Collections.swap(matching.getConnections(),Idx1,Idx2);
//	      } if (randDecision==1) {
//		    	  	if (randDeletion==0) {
//		    	  		boolean whichToDelete = rand.nextBoolean();
//		    	  		matching.getConnections().set((whichToDelete) ? Idx1 : Idx2, -1);
//		    	  	} if (randDeletion==1) {
//		    	  		matching.getConnections().set(Idx1,-1);
//		    	  		matching.getConnections().set(Idx2,-1);
//		    	  	}
//	      }  
//      }
//      
////      Collections.swap(occupied, Idx1, Idx2);
////      occupied = new ArrayList(occupied.subList(0, newSize));
////      
////      int Idx1P = Shuffle2.getFirst();
////      int Idx2P = Shuffle2.getSecond();
////      Collections.swap(newConnections, Idx1P, Idx2P);
////      newConnections = new ArrayList(newConnections.subList(0, newSize));
////      
////      for (int j = 0; j < matching.getConnections().size(); j++) {
////    	  	matching.getConnections().set(j, -1);
////      }
////      
////      for (int k = 0; k < newSize; k++) {
////    	  	matching.getConnections().set(occupied.get(k), newConnections.get(k));
////      }
//      
//	  final double proposedLogDensity = logDensity();
//	  final double ratio = Math.exp(proposedLogDensity - currentLogDensity);
//	  boolean u = Generators.bernoulli(rand, Math.min(1.0, ratio));
//	  if(!u) {
//		  for (int i = 0; i < deepcurrentState.size(); i ++ ) {
//			  matching.getConnections().set(i, deepcurrentState.get(i));
//		  }
//	  }	  
	  
//	    List<Integer> CurrentConnections = matching.getConnections(); 
//		ArrayList<Integer> deepcopyCurrentConnections = new ArrayList<Integer>(CurrentConnections); 
//		
//		double CurrentDensity = logDensity(); 
//		// System.out.println(CurrentDensity); 
//		
////		// Perform "independence" Uniform sampling, which is available in BipartiteMatching.xtend 
////		matching.sampleUniform(rand); 
////		List<Integer> NextConnections = matching.getConnections(); 
//		
//		ArrayList<Integer> emptyList = new ArrayList<Integer>();
//		for (int i=0; i < matching.getConnections().size(); i++) {
//			emptyList.add(i);
//		}
//		for (int i=0; i < matching.getConnections().size(); i++) {
//			emptyList.add(-1);
//		}
//		
//		shuffle(emptyList);
//		
//		ArrayList<Integer> proposedState = new ArrayList<Integer>();
//		
//		int countNextNegOne = 0;
//		int countCurrentNegOne = 0;
//		
//		for (int i=0; i < matching.getConnections().size(); i++) {
//			proposedState.add(emptyList.get(i));
//			if (emptyList.get(i)==-1) {countNextNegOne++;}
//			if (deepcopyCurrentConnections.get(i)==-1) {countCurrentNegOne++;}
//		}
//		
//		for (int i=0; i < matching.getConnections().size(); i++) {
//			matching.getConnections().set(i, proposedState.get(i));
//		}
//		
//		double NextDensity = logDensity(); 
//		// System.out.println(NextDensity); 
//		
//		double proposalDensityUp = factorial(matching.getConnections().size())/factorial(matching.getConnections().size()-countCurrentNegOne);
//		
//		double proposalDensityDown = factorial(matching.getConnections().size())/factorial(matching.getConnections().size()-countNextNegOne);
//		
//		double q_ratio = proposalDensityUp/proposalDensityDown;
//		double pi_ratio = Math.exp(NextDensity)/Math.exp(CurrentDensity);
//		
////		System.out.println(q_ratio);
////		System.out.println(pi_ratio);
////		System.out.println(Math.min(1.0, q_ratio*pi_ratio));
////		System.out.println("-----------------------------------------------------");
//		double alpha = Math.min(1.0, q_ratio*pi_ratio); 
//		System.out.println(alpha);
//		System.out.println("-----------------------------------------------------");
////		boolean u = rand.nextBernoulli(alpha); 
////		if (!u) {
////			for (int i = 0; i < deepcopyCurrentConnections.size(); i ++) { 
////				matching.getConnections().set(i, deepcopyCurrentConnections.get(i)); 
////			} 
////			// System.out.println("Next state is: \n \n \n" + permutation.getConnections()); 
////		} 
	  
	  
	      // The algorithm randomly select one vertex each time, and replace it with another vertex that has 
	      // currently not been occupied or FREE it if it is not free already.
		  List<Integer> currentState = matching.getConnections();
	      final double currentLogDensity = logDensity();
	      ArrayList<Integer> deepcurrentState = new ArrayList<Integer>(currentState);
	      int idx = rand.nextInt(matching.componentSize());
	      
	      // Create a list containing vertices that have not been occupied
	      ArrayList<Integer> LeftOver = new ArrayList<Integer>();
  	  	  for (int i = 0; i < matching.getConnections().size(); i ++) {
	  		if (! matching.getConnections().contains(i)) {
	  			LeftOver.add(i);
	  		}
	  	  }	  
  	  	  // If the current selected vertex is not free, add a free option to the 
  	  	  // left over list.
  	  	  if (matching.getConnections().get(idx)!=-1) {LeftOver.add(-1);}

	      int idxleftover = rand.nextInt(LeftOver.size());
	      
	      matching.getConnections().set(idx, LeftOver.get(idxleftover));  
		  final double nextLogDensity = logDensity();
		  final double ratio = Math.exp(nextLogDensity - currentLogDensity);
		  boolean u = Generators.bernoulli(rand, Math.min(1.0, ratio));
		  if(!u) {
			  for (int i = 0; i < deepcurrentState.size(); i ++ ) {
				  matching.getConnections().set(i, deepcurrentState.get(i));
			  }
		  }

}
  
  private double logDensity() {
    double sum = 0.0;
    for (LogScaleFactor f : numericFactors)
      sum += f.logDensity();
    return sum;
  }
  
//  private static double factorial(int N) {
//	  double multi = 1;
//	  for (int i = 1; i <= N; i++) {
//		  multi = multi*i;
//	  }
//	  return multi;
//  }
}


 
