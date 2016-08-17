import java.util.Arrays;
import java.util.stream.Collectors;
/**
 * Given a sorted array of integers, using the same array, shuffle the integers to have unique elements and return the index.
 * Sample input : [3, 3, 4, 5, 5, 6, 7, 7, 7]
 * Sample output : [3, 4, 5, 6, 7, X, X, X, X]
 * In this case, it returns an index of 4.
 * The elements in the array after that index is negligible (don't care what value it is).
 */
public class RemoveDupsFromArray {
    
    public static void main(String[] args) {
        int[] arr = new int[] {3, 3, 4, 5, 5, 6, 7, 7, 7};
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                arr[++i] = arr[j];
            }
        }

        for(int k = i+1; k < arr.length; k++) {
            arr[k] = -1;
        }

        System.out.println(Arrays
                           .stream(arr)
                           .boxed()
                           .collect(Collectors.toList()));
        System.out.println(i);
    }
}
