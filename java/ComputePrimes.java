import java.util.*;

/**
 * Sieve of eratosthenes print first n primes, based on input argument
 */
public class ComputePrimes {

    static List<Integer> primes = new ArrayList<>();
    
    public static void main(String[] args) {
        
        if (args.length == 0) {
            System.err.println("Pass in number of primes to be computed");
            System.exit(-1);
        }
        
        primes.add(2);
        int n = Integer.parseInt(args[0]);
        int i = 3;
        while (n > 0) {
            if (isPrime(i)) {
                primes.add(i);
                n--;
            }
            i++;
        }

        System.out.println(primes);
    }

    private static boolean isPrime(int i) {
        for (int k : primes) {
            if (i%k == 0) {
                return false;
            }
        }

        return true;
    }
}
