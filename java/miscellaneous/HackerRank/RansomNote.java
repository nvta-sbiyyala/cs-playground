import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        Map<String, Integer> magazineMap = new HashMap<>();
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            String key = in.next();
            magazineMap.compute(key, (k, v) -> v == null ? 1 : v+1);
        }
        Map<String, Integer> ransomMap = new HashMap<>();        
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            String key = in.next();
            ransomMap.compute(key, (k, v) -> v == null ? 1 : v+1);        
        }

        if (process(magazineMap, ransomMap)) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean process(Map<String, Integer> magazineMap, Map<String, Integer> ransomMap) {
        return !ransomMap.entrySet()
            .stream()
            .anyMatch(map -> !magazineMap.containsKey(map.getKey()) || map.getValue() > (magazineMap.get(map.getKey())));
    }
}
