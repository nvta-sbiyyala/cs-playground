import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LonelyInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        Set<Integer> mySet = Arrays.stream(a).boxed().collect(Collectors.toSet());
        System.out.println(2*mySet.stream().mapToInt(i -> i.intValue()).sum() - IntStream.of(a).sum());
    }
}
