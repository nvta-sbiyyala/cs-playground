/**
 * TODO: The solution is O(n^2) - improve using dynamic programming
 */
public class LongestPalindrome {
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Pass string whose longest palindrome substring needs to be found");
            System.exit(-1);
        }
        
        System.out.println(longestPalindrome(args[0]));
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }

        // initialize with first character
        String longest = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome centered around i (odd case)
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrom with center of i, i+1 (even case)
            tmp = helper(s, i, i+1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length()-1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }

        return s.substring(++begin, end);
    }
    
}
