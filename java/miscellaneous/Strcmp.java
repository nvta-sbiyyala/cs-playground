/**
 * Category: Bloomberg
 * Implement strcmp function of stdlib.h library without using any standard library.
 */
public class Strcmp {
    
    public static void main(String[] args) {
        assert(strcmp("foobar", "foobar") == 0);
        assert(strcmp("foobaz", "foobar") == 1);
        assert(strcmp("foobar", "foobaz") == -1);
        assert(strcmp("foobar", "foo") == 1);
        assert(strcmp("foo", "foobar") == -1);
        assert(strcmp("g", "foobar") == 1);
        assert(strcmp("f", "f") == 0);                
    }

    /**
     * Return:
     * 0 if equal
     * -1 if s1 lesser than s2
     * 1 if s1 greater than s2
     */
    private static int strcmp(String s1, String s2) {
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();

        int diff = s1.length() - s2.length();
        int sentinel = diff <= 0 ? s1.length() : s2.length();

        for (int i = 0; i < sentinel; i++) {
            if (s1CharArray[i] < s2CharArray[i]) {
                return -1;
            } else if (s1CharArray[i] > s2CharArray[i]) {
                return 1;
            } 
        }

        return diff == 0 ? 0 : diff/Math.abs(diff);
    }
    
}
