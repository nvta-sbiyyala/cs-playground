import java.util.*;

public class MergeThreeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 4, 7, 10, 13, 16, 19};
        int[] arr2 = new int[] {2, 5, 8, 11, 14};
        int[] arr3 = new int[] {3, 6, 9, 12, 15};
        System.out.println(Arrays.toString(simpleMerge(arr1, arr2, arr3)));
    }

    private static int[] simpleMerge(int[] arr1, int[] arr2, int[] arr3) {
        // first merge arr1 and arr2, then merge with arr3
        return classicMerge(classicMerge(arr1, arr2), arr3);
    }

    private static int[] classicMerge(int[] arrx, int[] arry) {
        int totalLength = arrx.length + arry.length;
        int[] res = new int[totalLength];

        int arr1Idx = 0, arr2Idx = 0;
        
        for (int i = 0; i < totalLength; i++) {
            if (arr1Idx == arrx.length) // arr1 has reached its end
                res[i] = arry[arr2Idx++];
            else if (arr2Idx == arry.length) // arr2 has reached its end
                res[i] = arrx[arr1Idx++];
            else if (arrx[arr1Idx] <= arry[arr2Idx]) 
                res[i] = arrx[arr1Idx++];
            else 
                res[i] = arry[arr2Idx++];
        }

        return res;
    }
}
