import java.io.*;
import java.util.*;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[][] array = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = in.nextInt();
            }
        }

        int d1Sum = 0;
        int d2Sum = 0;

        for (int i = 0; i < N; i++) {
            d1Sum += array[i][i];
        }

        for (int i = 0; i < N; i++) {
            d2Sum += array[i][N-i-1];
        }

        System.out.println(Math.abs(d1Sum-d2Sum));
    }
}
