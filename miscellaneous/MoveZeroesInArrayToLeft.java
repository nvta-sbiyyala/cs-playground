import java.util.Arrays;

/**
 * Given an unsorted integer array, place all zeros to the end of the array without changing the sequence of non-zero
 * elements. (i.e. [1,3,0,8,12, 0, 4, 0,7] --> [1,3,8,12,4,7,0,0,0])
 */
public class MoveZeroesInArrayToLeft {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,0,8,12, 0, 4, 0,7};
        move(arr);
        
        assert(Arrays.equals(arr, new int[]{1,3,8,12,4,7,0,0,0}));
    }

    private static void move(int[] arr) {
        int count = 0;
        for (int elem : arr) {
            if (elem == 0) count++;
        }

        if (count == 0) return;

        int firstIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[firstIdx++] = arr[i];
            }
        }

        for (int i = arr.length-count; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
}
