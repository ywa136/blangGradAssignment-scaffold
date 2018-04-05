## Basic sampler for permutations

Each time in the iteration, the sampler randomly select a pair of vertices that are conected in the current connections; the sampler then swap their connections to obtain a new state. The proposed state is accepted with probability equals to the ratio between the target density of the proposed state and the previous state. Thus, this sampler is general (i.e., able to handle both uniform and non-uniform cases).

The Markov chain sampled using this algorithm is $\pi$-reversible since one can always get back to the previous state by the same move, i.e., swap the pair. Therefore, the chain is $\pi$-invariant in theory. Irreducibility of the chain is obvious as it quickly explores the whole space by random selection of exchange.  


## Sampler for bipartite matching

Each time in the iteration, the sampler randomly select one vertex in the connection of the current state; the sampler then replace it with a randomly selected vertex that is currently not occupied in the current connection; if it is not free already, it is possible to set it free at random. The proposed state is accepted with probability equals to the ratio between the target density of the proposed state and the previous state.

The Markov chain sampled using this algorithm is $\pi$-reversible since one can always get back to the previous state by the same move, i.e., $q(X^{\ast}|X)=q(X|X^{\ast})$, where $X$ is the current state and $X^{\ast}$ the proposed state.


## Description of DiscreteMCTest

1. Initialize a bi-directional map between integers and state representatives (i.e., an instance of permutations).

2. Initialize a 1-by-n dense matrix object for storing target distribution.

3. Initialize an object for storing transition matrix for each MCMC kernel under study.

4. Create a DiscreteMCTest object under the class:
	* Initiate the ExhaustiveDebugRandom class for debugging the discrete sampling model by exhasutively list all possible outcomes.
	* Increment the probability of the ramdom object sampled.
	* Compute the normalized target distribution.
	* For each kernel used in the sampler compute the empirical transition matrices by calculating the probabilities of the transition process among all possible state.

5. Check invariance of each transition kernel by multiplying the target and the transition and see if the same matrix is outputed. Here we test invariance for each kernel seperately and as a result, the mixture of them will be invariant to the target distribution in theory. We do not test with the mixture directly since if the test fails we are not able to track down the individual kernel(s) who failed the invariance test.
	
6. Check the irreducibility of the mixture of kernels: first mix uniformly all kernels with an identity matrix; then starting at an arbitrary state and cheking whether the chain is able to reach all possible states within number of steps equal the size of the state space. We often need more that one update mechanism for the same target to obtain a new update mechanism that preserves the specified target distribution but satisfies irreducibility. It is clear that mixing of several kernels (i.e., update mechnisams) preserves the specified distribution, because no matter which individual kernel is chosen the target distribution is preserved. 	


## Description of ExhaustiveDebugRandom

1. Initialize a decision tree for debugging and sampling from a discrete probability model. The variabe **hasNext** indicates whether the debugger has explored the whole sapce of the model. The variable **lastPribability** calculates the probability of a specified state in the model.

2. **nexBernoulli** calls the **nextCategorical** to sample either a $0$ or $1$ with probability $1-p$ and $p$.

3. **nextCategorical** samples from any categorical(discrete) probability distribution. It proceeds by constructing a binary search tree with each leaf being a particular category. The algorithm then prunes back the tree and increments probabilities of a category and finally samples a category with the highest probability.

4. **nextInt** implements **nextCategorical** to sample uniformly from a list of consecutive non-negative integers.

## PermutedClustering

Here we attach the posterior probability [plot](https://github.com/ywa136/blangGradAssignment-scaffold/blob/master/permutations-posterior.pdf) for the fitted model.
 