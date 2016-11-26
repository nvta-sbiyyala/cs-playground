import java.io.*;
import java.util.*;

/**
 * a. reverse(S) denotes the string obtained by reversing string . E.g.: reverse("abc") = "cba"
 * b. shuffle(S) denotes any string that's a permutation of string . E.g.: shuffle("god") ∈ ['god', 'gdo', 'ogd', 'odg', 'dgo', 'dog']
 * c. merge(S1,S2) denotes any string that's obtained by interspersing the two strings  & , maintaining the order of characters in both. 
 * E.g.: S1 = "abc" & S2 = "def", one possible result of merge(S1,S2) could be "abcdef", another could be "abdecf", another could be "adbecf" and so on.
 * Given a string  such that  merge(reverse(A), shuffle(A)), for some string , can you find the lexicographically smallest ?
 *
 * TODO: In-progress
*/
public class ReverseShuffleMerge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.next();
        System.out.println(reverse(input));

        System.out.println(isShuffle(input, reverse(input)));
                
    }

    private static String reverse(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length()/2; i++) {
            char tmp = charArray[i];
            charArray[i] = charArray[s.length()-i-1];
            charArray[s.length()-i-1] = tmp;
        }

        return new String(charArray);
    }

    private static boolean isShuffle(String s1, String s2) {        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return new String(arr1).equals(new String(arr2));
    }
}
