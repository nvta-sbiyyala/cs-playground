import java.util.*;
import java.util.stream.*;

/**
 * On old cell phones, users typed on a numeric keypad and the phone would provide a list
 * of words that matched these numbers. Each digit mapped to a set of O - 4 letters.
 * Implement an algorithm to return a list of matching words, given a sequence of digits.
 * You are provided a set of valid words 
 */
public class T9Trie {

    char [][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    
    public static void main(String[] args) {
        assert (testTrie());

        Trie trie = new Trie(new String[]{"apple", "ball", "tree", "used"});
        T9Trie t9 = new T9Trie();
        
        assert(t9.getValidT9Words("8733", trie)
               .equals(Arrays.asList(new String[]{"tree", "used"})));
    }

    ArrayList<String> getValidT9Words(String number, Trie trie) {
        ArrayList<String> results = new ArrayList<>();
        getValidWords(number, 0, "", trie.getRoot(), results);
        return results;
    }

    void getValidWords(String number,
                       int idx,
                       String prefix,
                       TrieNode trieNode,
                       ArrayList<String> result) {

        if (number.length() == idx) {            
            if (trieNode.terminates()) {
                result.add(prefix);
            }
            return;
        }

        // get number from current idx
        char digit = number.charAt(idx);
        char[] letters = getT9Chars(digit);
        for (char c : letters) {
            TrieNode childNode = trieNode.getChild(c);
            if (childNode != null) { // traverse deeper
                getValidWords(number, idx+1, prefix+c, childNode, result);
            }
        }
    }

    char[] getT9Chars(char digit) {
        if (!Character.isDigit(digit)) {
            return null;
        }

        int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
        return t9Letters[dig];
    }    

    static boolean testTrie() {
        List<String> list = Arrays.asList("sheldon",
                                          "cooper",
                                          "dinesh",
                                          "gilfoyle");
        Trie trie = new Trie(list);
        return trie.contains("gil") && trie.contains("dinesh");
    }
}

class Trie {
    // The root of this trie.
    private TrieNode root;

    /* 
     * Takes a list of strings as an argument, and constructs a trie that stores 
     * these strings
     */
    public Trie(List<String> list) {
        root = new TrieNode();
        list.forEach(word -> root.addWord(word));
    }

    public Trie(String[] list) {
        root = new TrieNode();
        for (String word : list) {
            root.addWord(word);
        }
    }

    /* 
     * Checks whether this trie contains a string with the prefix passed in as argument
     * 'exact' is a flag which tells if the prefix is the word i.e. exact match
     * 
     */
    public boolean contains(String prefix, boolean exact) {
        TrieNode lastNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if (lastNode == null) {
                return false;
            }
        }

        return !exact || lastNode.terminates();
    }

    public boolean contains(String prefix) {
        return contains(prefix, false);
    }

    public TrieNode getRoot() {
        return root;
    }
}

class TrieNode {

    /* The children of the node in the trie. */
    private HashMap<Character, TrieNode> children;
    private boolean terminates = false;

    /* The character stored in this node as data as well */
    private char character;

    /* Constructs an empty trie node and initializes the list of 
     * its children to empty hash map. Used only to construct the
     * root node of the trie. */
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }

    public TrieNode(char character) {
        this();
        this.character = character;
    }

    /* Returns the character data stored in this node. */
    public char getChar() {
        return character;
    }

    public void addWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        char firstChar = word.charAt(0);

        TrieNode child = getChild(firstChar);
        if (child == null) {
            child = new TrieNode(firstChar);
            children.put(firstChar, child);
        }

        if (word.length() > 1) {
            child.addWord(word.substring(1));
        } else {
            child.setTerminates(true);
        }
    }

    /**
     * Find a child node of this node that has the char argument as its data. 
     * Return null if no such child node is present in the trie.
     */
    public TrieNode getChild(char c) {
        return children.get(c);
    }

    public boolean terminates() {
        return terminates;
    }

    public void setTerminates(boolean t) {
        terminates = t;
    }
        
}
