# A collection of problems with solutions in *java* from platforms such as:
1. HackerRank
2. EulerProject
3. Interview Cake
4. Careercup
5. My solutions to problems already solved by colleague(s) - <br/> 
   i. Haytham. A [https://github.com/haldokan] (Thanks!)
   
### Enable assertions
java -ea <.Class File>

## Tech-Debt
All the implementations are very c-style and declarative; the modern programming is fast moving towards functional programming, and such style is frowned upon. Especially the tree-problems have numerous null-checks and multiple exit points. TODO: Refactor using Java 8 constructs. 

#### The way *LowestCommonAncestor.java* is solved is a classic example of brittle imperative style programming. 
TODO: Refactor such implementations using functional constructs 
