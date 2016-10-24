import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        //String magazine[] = new String[m];
        Map<String, Integer> magazineMap = new HashMap<>();
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            //magazine[magazine_i] = in.next();
            String key = in.next();
            magazineMap.compute(key, (k, v) -> v == null ? 1 : v+1);
        }
        //String ransom[] = new String[n];
        Map<String, Integer> ransomMap = new HashMap<>();        
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            //ransom[ransom_i] = in.next();
            String key = in.next();
            ransomMap.compute(key, (k, v) -> v == null ? 1 : v+1);        
        }

        if (process(magazineMap, ransomMap)) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean process(Map<String, Integer> magazineMap, Map<String, Integer> ransomMap) {
        for (Map.Entry<String, Integer> e : ransomMap.entrySet()) {
            String key = e.getKey();
            if (!magazineMap.containsKey(key) || e.getValue() > (magazineMap.get(key))) return false;                 }

        return true;
    }
}
