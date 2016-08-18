import java.util.*;
import java.util.stream.*;

/**
 * On old cell phones, users typed on a numeric keypad and the phone would provide a list
 * of words that matched these numbers. Each digit mapped to a set of O - 4 letters.
 * Implement an algorithm to return a list of matching words, given a sequence of digits.
 * You are provided a set of valid words 

 * Solving the T9 problem by precomputing combinations to dictionary words 
 * Iterate over the dictionary, get the corresponding code 
 * put (code, word) into a map<code, List<words>>
 */
public class T9PreComputedMap {

    private char [][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    private Map<Character, Integer> reverseMap = new HashMap<>();

    private Map<String, List<String>> codeToWords = new HashMap<>();
    
    public T9PreComputedMap() {
        populateReverseMap();
        // initialize the map
        populateDictionary(new String[]{"apple", "bat", "ball", "tree", "used"});
    }

    private void populateReverseMap() {
        
        for (int i = 2; i < t9Letters.length; i++) {
            for (char c : t9Letters[i]) {
                reverseMap.put(c, i);
            }
        }
    }

    /**
     * Generates the mapping between code and corresponding list of words and returns it
     */
    private void populateDictionary(String[] words) {
        // for each word, get the corresponding code
        Arrays.stream(words)
            .forEach(elem -> {
                    String code = getCode(elem);
                    List<String> li = codeToWords.get(code);
                    if (li == null) li = new ArrayList<String>();
                    li.add(elem);
                    codeToWords.put(code, li);
                });
    }

    private String getCode(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            Integer res = reverseMap.get(c);
            if (res != null)
                sb.append(res);
        }
        return sb.toString();
    }
    
    private char[] getT9Chars(char digit) {
        if (!Character.isDigit(digit)) {
            return null;
        }

        int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
        return t9Letters[dig];
    }

    public List<String> getValidT9Words(String code) {
        return codeToWords.get(code);
    }

    public static void main(String[] args) {
        T9PreComputedMap t9 = new T9PreComputedMap();
        assert(t9.getValidT9Words("8733")
               .equals(Arrays.asList(new String[]{"tree", "used"})));
    }

}
