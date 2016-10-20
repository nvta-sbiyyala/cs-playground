public class Gcd {
    public static void main(String[] args) {
        assert(computeGcd(56, 5) == 1);
        assert(computeGcd(56, 5) == computeGcdRecursively(56, 5));
        
        assert(computeGcd(1565, 5) == 5);
        assert(computeGcd(1565, 5) == computeGcdRecursively(1565, 5));

        assert(computeGcd(34, 68) == 34);
        assert(computeGcd(34, 68) == computeGcdRecursively(34, 68));
    }

    private static int computeGcd(int dividend, int divisor) {
        while (divisor > 0) {
            int remainder = dividend % divisor;
            dividend = divisor;
            divisor = remainder;
        }

        return dividend;
    }

    private static int computeGcdRecursively(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend;
        }

        return computeGcdRecursively(divisor, dividend%divisor);
    }
    
}
