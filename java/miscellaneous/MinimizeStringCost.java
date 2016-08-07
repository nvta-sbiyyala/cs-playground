import java.util.PriorityQueue;

/**
 * Category: Careercup
 * Find an algorithm that minimizes the cost of adding such a series of strings.
 */
public class MinimizeStringCost {
    public static void main(String[] args) {
        assert(minCost(new String[] {"abc", "def", "gh"}) == 13);
        assert(minCost(new String[] {"abc", "def", "gh", "z", "a"}) == 22);
    }

    private static int minCost(String[] args) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<Integer> ((i1, i2) -> i1 - i2);

        // nlog(n)
        for (String s : args) {
            minPQ.add(s.length());
        }
        
        int sum = 0;
        while (minPQ.size() > 1) { // remove smallest, add back sum
            int toAdd = minPQ.poll() + minPQ.poll();
            sum += toAdd;
            // log(n)
            minPQ.add(toAdd);
        }
        //Overall: nlog(n)
        return sum;
    }
    
}
