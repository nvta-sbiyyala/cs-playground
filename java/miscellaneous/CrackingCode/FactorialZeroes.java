/**
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 * The vanilla (read: stupid) solution is to compute the factorial of the number 
 * and count zeroes at the end
 * A sharper solution is count number of factors of 5 - this scales for really large 
 * numbers as well
 */
public class FactorialZeroes {
    public static void main(String[] args) {
	int n = Integer.parseInt(args[0]);
	System.out.println(bookSoln(n));
    }

    static int bookSoln(long n) {
	int count = 0;
	if (n < 0) {
	    return -1;
	}
	
	for (int i = 5; n/i > 0; i*=5) {
	    count += n/i;
	}

	return count;
    }
    
    static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }

        return res;
    }
}
