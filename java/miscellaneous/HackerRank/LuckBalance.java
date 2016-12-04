import java.io.*;
import java.util.*;

public class LuckBalance {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // Map<Integer, SortedSet<Integer>>
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        Map<Integer, List<Integer>> mapping = new HashMap<>();
        mapping.put(0, new ArrayList<Integer>());
        mapping.put(1, new ArrayList<Integer>());
        
        for (int i = 0; i < N; i++) {
            int li = in.nextInt();
            int ti = in.nextInt();
        
            mapping.compute(ti, (k, v) -> process(v, li));
        }

        System.out.println(computeLuck(mapping, K));        
    }

    static int computeLuck(Map<Integer, List<Integer>> mapping, int K) {

        List<Integer> impSet = mapping.get(1);
        List<Integer> unimpSet = mapping.get(0);

        Collections.sort(impSet, (e1, e2) -> e2.compareTo((Integer) e1));
        Collections.sort(unimpSet, (e1, e2) -> e2.compareTo((Integer) e1));
        
        return impSet.stream().mapToInt(Integer::intValue).limit(K).sum() -
            impSet.stream().skip(K).mapToInt(i -> i).sum() +
            unimpSet.stream().mapToInt(i -> i).sum();

    }

    static List process(List<Integer> set, Integer li) {
        set.add(li);
        return set;
    }
}
