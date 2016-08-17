import java.util.*;
import java.util.stream.*;

public class SumSwap {
    
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 2, 1, 1, 2};
        int[] arr2 = {3, 6, 3, 3};
        assert(sumSwap(arr1, arr2).length == 2);
    }

    /**
     * near-linear time
     */
    static int[] sumSwap(int[] a1, int[] a2) {

        int s1 = Arrays.stream(a1).sum();
        int s2 = Arrays.stream(a2).sum();
        Set<Integer> s2Set = Arrays
            .stream(a2)
            .boxed()
            .collect(Collectors.toSet());
        
        int targetDiff = s1 - s2;
        if (targetDiff % 2 != 0) return new int[] {};

        targetDiff /= 2;
        
        for (int i : a1) {
            int candidate = i-targetDiff;
            if (s2Set.contains(candidate))
                return new int[]{i, candidate};
        }

        return new int[]{};
    }
    
}
