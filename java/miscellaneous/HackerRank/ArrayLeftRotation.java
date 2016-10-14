import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * O(n) time, space
 */
public class ArrayLeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Integer a[] = new Integer[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        Arrays.asList(transform(a, n, k)).stream()
            .forEach(x -> System.out.print(x + " "));
    }

    static Integer[] transform(Integer[] a, int n, int k) {
        k = k % n; // sentinel operation
        Integer[] aux = new Integer[a.length];
        for (int i = 0; i < n; i++) {
            k = k % n;
            aux[i] = a[k++];
        }

        return aux;
    }

    static void swap(Integer[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
