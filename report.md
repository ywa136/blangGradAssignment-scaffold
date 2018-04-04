## DiscreteMCTest

1. Initialize a bi-directional map between integers and state representatives (i.e., an instance of permutations).

2. Initialize a 1-by-n dense matrix object for storing target distribution.

3. Initialize an object for storing transition matrix for each MCMC kernel under study.

4. Create a DiscreteMCTest object under the class:
	* Initiate the ExhaustiveDebugRandom class for debugging the discrete sampling model by exhasutively list all possible outcomes.
	* Increment the probability of the ramdom object sampled.
	* Compute the normalized target distribution.
	* For each kernel used in the sampler compute the empirical transition matrices by calculating the probabilities of the transition process among all possible state.

5. Check invariance of each transition kernel by multiplying the target and the transition and see if the same matrix is outputed. 
	
6. Check the irreducibility of the mixture of kernels: first mix uniformly all kernels with an identity matrix; then starting at an arbitrary state and cheking whether the chain is able to reach all possible states within number of steps equal the size of the state space. We often need more that one update mechanism for the same target to obtain a new update mechanism that preserves the specified target distribution but satisfies irreducibility. It is clear that mixing of several kernels (i.e., update mechnisams) preserves the specified distribution, because no matter which individual kernel is chosen the target distribution is preserved. 	


## ExhaustiveDebugRandom

1. Initialize a decision tree for debugging and sampling from a discrete probability model. The variabe **hasNext** indicates whether the debugger has explored the whole sapce of the model. The variable **lastPribability** calculates the probability of a specified state in the model.

2. **nexBernoulli** calls the **nextCategorical** to sample either a $0$ or $1$ with probability $1-p$ and $p$.

3. **nextCategorical** samples from any categorical(discrete) probability distribution. It proceeds by constructing a binary search tree with each leaf being a particular category. The algorithm then prunes back the tree and increments probabilities of a category and finally samples a category with the highest probability.

4. **nextInt** implements **nextCategorical** to sample uniformly from a list of consecutive non-negative integers.

## PermutedClustering

Here we attach the posterior probability plot for the fitted model:

![](permutations-posterior.pdf)
 