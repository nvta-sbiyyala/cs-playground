import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBrackets {

    static Set<Character> startSet = new HashSet<>(Arrays.asList(new Character[]{'{', '[', '('}));
    static Set<Character> endSet = new HashSet<>(Arrays.asList(new Character[]{'}', ']', ')'}));

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            boolean answer = isBalanced(expression);
            if(answer)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean isBalanced(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = expression.toCharArray();
        for (char c : arr) {
            if (startSet.contains(c)) {
                stack.push(c);
            } else if (endSet.contains(c)) {
                if (stack.isEmpty() || !isPair(stack.peek(), c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
                           
    }

    private static boolean isPair(char c1, char c2) {

        switch (c1) {
        case '{':
            return c2 == '}';
        case '[':
            return c2 == ']';
        case '(':
            return c2 == ')';
        default:
            break;
        }
        
        return false;
    }
}
