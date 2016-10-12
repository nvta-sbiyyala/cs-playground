import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ContactsApplication {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ContactsTrie contactsTrie = new ContactsTrie();
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            switch(op) {
            case "add":
                contactsTrie.add(contact);
                break;
            case "find":
                System.out.println(contactsTrie.find(contact));
                break;
            default:
                break;
            }
        }
    }
}

class ContactsTrie {

    TrieNode root;

    public ContactsTrie() {
        this.root = new TrieNode();
    }

    public void add(String name) {
        root.add(name);
    }

    public int find(String name) {
        return root.findCount(name);
    }
            
}

class TrieNode {

    Map<Character, TrieNode> childrenMap = new HashMap<>();
    boolean terminates;
    int childCount = 1;

    public TrieNode() {
        // no-op
    }

    public void add(String name) {

        if(name == null || name.isEmpty()) {
            return;   
        }

        childCount += 1;

        Character c = name.charAt(0);
        TrieNode tmpNode = childrenMap.get(c);
        if (tmpNode == null) {
            tmpNode = new TrieNode();
            childrenMap.put(c, tmpNode);
        }

        if (name.length() > 1) {
            tmpNode.add(name.substring(1));                
        } else {
            terminates = true;
        }
    }

    public int findCount(String name) {
        if (name.length() == 0) {
            return this.childCount;   
        }

        Character c = name.charAt(0);
        TrieNode tmpNode = childrenMap.get(c);

        if (tmpNode == null)
            return 0;

        return tmpNode.findCount(name.substring(1));
    } 

    public TrieNode getChild(Character c) {
        return childrenMap.get(c);
    }

    public String toString() {
        return childrenMap.toString();
    } 
}
