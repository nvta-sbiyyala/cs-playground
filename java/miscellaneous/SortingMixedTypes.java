import java.util.*;

/**
 * nlog(n) solution
 */
public class SortingMixedTypes {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Pass mixed type entry to sorted");
            System.exit(-1);
        }
        
        System.out.println(sort(args[0]));
    }

    private static String sort(String s) {
        List<Character> charNodeList = new ArrayList<>();
        List<Integer> intNodeList = new ArrayList<>();

        List<Integer> sortedCharIdxList = new ArrayList<>();
        List<Integer> sortedIntIdxList = new ArrayList<>();
        
        char[] charArray = s.toCharArray();
        int zero = '0';
        for (int i = 0; i < charArray.length; i++) {
            int tmp = charArray[i];
            if (tmp < 97) { // assume non-char [integer in this case]
                // store i here
                sortedIntIdxList.add(i);
                intNodeList.add((charArray[i] - zero));
            } else { // assume char
                sortedCharIdxList.add(i);
                charNodeList.add(charArray[i]);
            }
        }

        // sort the respective lists
        charNodeList.sort(Character::compareTo);
        intNodeList.sort(Integer::compareTo);

        // sorted idxList
        sortedCharIdxList.sort(Integer::compareTo);
        sortedIntIdxList.sort(Integer::compareTo);

        char[] resultArray = new char[s.length()];

        for (int i = 0; i < sortedCharIdxList.size(); i++) {
            int tmpIdx = sortedCharIdxList.get(i);
            resultArray[tmpIdx] = charNodeList.get(i);
        }

        for (int i = 0; i < sortedIntIdxList.size(); i++) {
            int tmpIdx = sortedIntIdxList.get(i);
            resultArray[tmpIdx] = (char) (intNodeList.get(i) + zero);
        }

        return new String(resultArray);
    }
}
