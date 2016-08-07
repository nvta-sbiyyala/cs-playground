/**
 * Find out the max value in an array using recursion
 */
public class ArrayMaxValueRecursion {
    public static void main(String[] args) {
        System.out.println(maxValue(new int[]{3, 1, 0, 8, 6, 2, 10, 1, 3}));
        System.out.println(maxValue(new int[]{300, 5, 653, -90}));
    }

    private static int maxValue(int[] arr) {
        return helper(arr, 0, 0);
    }

    private static int helper(int[] arr, int start, int currentMax) {
        if (start == arr.length) {
            return currentMax;
        }

        if (currentMax < arr[start]) {
            currentMax = arr[start];
        }
        
        return helper(arr, start+1, currentMax);
    }
}
