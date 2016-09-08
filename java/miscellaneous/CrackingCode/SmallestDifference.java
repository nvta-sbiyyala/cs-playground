import java.util.*;

/**
 * Given two arrays of integers, compute the pair of values (one value in each array) with the smallest (non-negative) difference. Return the difference.
 * The two pointer formula - yet again
 */
public class SmallestDifference {

    public static void main(String[] args) {
	int[] a1 = new int[] {1, 3, 15, 11, 2};
	int[] a2 = new int[] {23, 127, 235, 19, 8};
	System.out.println(findSmallestDifference(a1, a2));
    }

    private static int findSmallestDifference(int[] a1, int[] a2) {
	Arrays.sort(a1);
	Arrays.sort(a2);
	System.out.println(Arrays.toString(a1));
	System.out.println(Arrays.toString(a2));
	int limit = a1.length > a2.length ? a2.length : a1.length;

	int diff = Integer.MAX_VALUE;
	int p1 = 0, p2 = 0;
	for (; p1 < a1.length && p2 < a2.length;) {
	    int tmpDiff = Math.abs(a1[p1]-a2[p2]);
	    if (tmpDiff < diff) {
		diff = tmpDiff;
	    }
	    if (a1[p1] <= a2[p2]) {
		++p1;
	    } else {
		++p2;
	    }
	}
	
	return diff;
    }
}
