import java.util.*;
import java.util.stream.Collectors;

/**
 * convert an Integer to binary
 */
public class IntegerToBinary {
    public static void main(String[] args) {
        System.out.println(binaryBitwise(Integer.parseInt(args[0])));
        System.out.println(toBinary(Integer.parseInt(args[0])));
    }

    /**
     * Using right-shift operator
     */
    private static String binaryBitwise(int n) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                stack.push(1);
            } else {
                stack.push(0);
            }
        }

        return stack
            .stream()
            .map(String::valueOf)
            .collect(Collectors.joining());
    }

    /**
     * base 2 conversion method
     */
    private static String toBinary(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (n > 1) {
            int rem = n % 2;
            n = n/2;
            stack.push(rem);
        }

        if (n == 0) {
            stack.push(n);
        } else {
            stack.push(1);
        }

        return stack
            .stream()
            .map(String::valueOf)
            .collect(Collectors.joining());
    }
}
