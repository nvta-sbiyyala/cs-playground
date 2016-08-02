import java.util.Arrays;
/*
 * You have an array of ints. Move all elements of a specific value to the left while keep the sequence.
 * To Run: java -ea MoveArrayValueToLeft
 */
public class MoveArrayValueToLeft {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3, 2, 2, 7, 5, 2, 9, 8};
        move(arr, 2);
        assert(Arrays.equals(arr, new int[]{2, 2, 2, 2, 5, 3, 7, 5, 9, 8}));

        arr = new int[]{42, 1, 24343, 1, 1, 54, 653, 1, 244, 1, 4346, 1, 545};
        move(arr, 1);
        assert(Arrays.equals(arr, new int[]{1, 1, 1, 1, 1, 1, 42, 24343, 54, 653, 244, 4346, 545}));
    }

    /**
     * Algorithm: 
     * First pass to count no. of occurences of x
     * Second pass to move non-x value to [count+1...len]
     * Third pass to fill [0...count] with x
     * O(n)
     */
    private static void move(int[] arr, int x) {
        int count = 0;
        for (int elem : arr) {
            if (elem == x) count++;
        }

        // iterate from the last
        int lastIdx = arr.length-1;
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] != x) { // decrement filler
                arr[lastIdx--] = arr[i];
            }
        }

        for (int i = 0; i <= count-1; i++) {
            arr[i] = x;
        }
    }
}
