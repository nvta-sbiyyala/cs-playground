import java.util.*;

/**
 * http://www.geeksforgeeks.org/microsoft-interview-178/
 * solutions reference: http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * Question: Given notes of different denominations ( 1,2,5,10) , WAP to find in how many ways can you make an amount ‘x’ ?
 */
public class Denominations {
    static int counter  = 0;
    
    public static void main(String[] args) {
        //int[] denominationsArray1 = new int[] {1,2,5,10};
        int[] denominationsArray1 = new int[] {1, 2, 5, 10, 25, 50, 100, 150, 200, 250};
        // 
        assert(countUniqueCombinationsDP(denominationsArray1, denominationsArray1.length, 1000) == 476162330);
        assert(countUniqueCombinationsDP(denominationsArray1, denominationsArray1.length, 1000) ==
               countUniqueCombinationsDPOptimized(denominationsArray1, denominationsArray1.length, 1000));
    }

    /**
     * Return unique ways to sum upto target
     * The recursive approach divides the problem into 2 classes
     * 1. solutions with a (atleast one) particular element 
     * 2. solutions without a particular element
     */
    private static int countUniqueCombinationsRecursive(int[] denominationsArray, int numDenoms, int target) {
        // base case
        if (target == 0) return 1;
        if ((numDenoms <= 0 && target > 0) || target < 0) return 0;

        return countUniqueCombinationsRecursive(denominationsArray, numDenoms-1, target) +
            countUniqueCombinationsRecursive(denominationsArray, numDenoms, target-denominationsArray[numDenoms-1]);
    }

    /**
     * Use dynamic programming to avoid repetitive computations
     * An array of size a[target+1][numDenoms]
     */
    private static int countUniqueCombinationsDP(int[] denominationsArray, int numDenoms, int target) {
        // when target=0, #ways is always 1
        int[][] result = new int[target+1][numDenoms];
	
        for (int i = 0; i < numDenoms; i++)
            result[0][i] = 1;

        // fill the rest
        for (int i = 1; i < target+1; i++) {
            for (int j = 0; j < numDenoms; j++) {
                // Count number of solutions including denominationsArray[j]
                int x = (i - denominationsArray[j] >= 0) ? result[i - denominationsArray[j]][j] : 0;

                // Count of solutions excluding S[j]
                int y = (j >= 1) ? result[i][j-1] : 0;

                result[i][j] = x + y;
            }
        }

        return result[target][numDenoms-1];
    }

    /**
     * Use dynamic programming to avoid repetitive computations
     * Avoiding auxiliary space
     * Every element represents number of solutions 
     */
    private static long countUniqueCombinationsDPOptimized(int[] denominationsArray, int numDenoms, int target) {
        long[] result = new long[target+1];
        
        result[0] = 1;
        
        // fill the rest
        for (int i = 0; i < numDenoms; i++) {
            for (int j = denominationsArray[i]; j < target+1; j++) {
                result[j] += result[j - denominationsArray[i]];
            }
        }

        return result[target];
    }
    
}
