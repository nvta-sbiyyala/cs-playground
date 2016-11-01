import java.util.*;

public class DavisStaircase {

    static int[] options = new int[] {1, 2, 3};

    static Map<Integer, Integer> mapping = new HashMap<>();
    
    public static void main(String[] args) {
        mapping.put(0, 1);
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(computePermutationsCache(n));
        }
    }

    private static int computePermutations(int n) {
        if (n == 0) 
            return 1;
        if (n < 0)
            return 0;

        return computePermutations(n-1) + computePermutations(n-2) 
            + computePermutations(n-3);
    }

    private static int computePermutationsCache(int n) {
        if (n < 0) {
            return 0;
        } else if (mapping.containsKey(n)) {
            return mapping.get(n);
        } else {
            Integer newVal = computePermutationsCache(n-1) + computePermutationsCache(n-2) 
                + computePermutationsCache(n-3);
            mapping.put(n, newVal);
            return mapping.get(n);
        }
    }

}
