import java.io.*;
import java.util.*;

/**
 * Category: HackerRank
 * Find the median of an array of integers
 * It is guaranteed that the size of array is odd
 */
public class FindMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

       System.out.println(findMedian(a));
    }

    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    private static int partition(int[] a, int lo, int hi) {
        int retValue = 0;
        int i = lo;
        int j = hi + 1;

        // pivot
        int v = a[lo];

        while (true) {

            // find item on lo to swap
            while (a[++i] < v) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (a[--j] > v) {
                if (j == lo) break;
            }

            // check if pointers have crossed
            if (i >= j) break;

            exch(a, i, j);
        }

        // put v = a[j] into position
        exch(a, lo, j);
        
        return j;
    }

    private static int findMedian(int[] a) {
        int target = a.length/2;

        int lo = 0;
        int hi = a.length-1;
        while (lo <= hi) {
            int j = partition(a, lo, hi);
            if (j > target) {
                hi = j-1;
            } else if (j < target) {
                lo = j+1;
            } else {
                return a[j];
            }
        }
        
        return -1;
    }

}
