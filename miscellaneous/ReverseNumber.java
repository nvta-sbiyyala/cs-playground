public class ReverseNumber {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(reverse(n));
    }

    private static int reverse(int n) {
        int reverseN = 0;
        while (n != 0) {
            int rem = n%10;
            n = n/10;
            reverseN = reverseN*10 + rem;
        }

        return reverseN;
    }
}
