import java.util.*;

/**
 * Category: HackerRank
 * Use 2 PQ's - one MaxPQ and another MinPQ
 * Approach:
 * 1. Even: mean of highest(MaxPQ) and lowest(Min)
 * 2. Odd: Take the root of the PQ with larger size
 */
public class RunningMedian {

    static PriorityQueue<Integer> maxPQ = new PriorityQueue<>((e1, e2) -> e2-e1);
    static PriorityQueue<Integer> minPQ = new PriorityQueue<>((e1, e2) -> e1-e2);
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        for (int i = 0; i < N; i++) {
            int elem = in.nextInt();
            // current size
            System.out.println(fetchMedian(elem));
        }
    }

    private static double fetchMedian(int elem) {

        if (minPQ.size() != 0 && elem > minPQ.peek()) { // add to right
            minPQ.add(elem);
        } else {
            maxPQ.add(elem);
        }

        double res = 0.0;

        // Balance the PQ's such that difference is atmost 1, and maxPQ.size() >= minPQ.size()
        int diff = maxPQ.size() - minPQ.size();
        if (diff == 2) minPQ.add(maxPQ.poll());
        else if (diff == -2) maxPQ.add(minPQ.poll());

        int maxSize = maxPQ.size();
        int minSize = minPQ.size();

        // find/compute median
        if((maxSize + minSize)%2 == 1) {
            if (maxSize > minSize)
                res = (double) maxPQ.peek();
            else
                res = (double) minPQ.peek();
        } else {
            res = (double) (maxPQ.peek() + minPQ.peek())/2;
        }
        
        return res;
    }

}
