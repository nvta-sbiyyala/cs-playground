import java.io.*;
import java.util.*;

public class GoodlandElectricity {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] cityTowerArray = new int[N];
        List<Integer> citiesWithTowers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cityTowerArray[i] = in.nextInt();
            if (cityTowerArray[i] == 1)
                citiesWithTowers.add(i);
        }

        int optimalTowers = process(cityTowerArray, citiesWithTowers, K);

        System.out.println(optimalTowers);
    }

    static int process(int[] towerArray, List<Integer> citiesWithTowers, int limit) {
        int switchCount = 0;
        int ptr = 0;
        int cur = 0;
        int n = towerArray.length;

        for (;;) {
            if (cur >= n)
                break;
            while (ptr < citiesWithTowers.size() && citiesWithTowers.get(ptr) - limit < cur)
                ptr++;
            
            if (ptr == 0)
                return -1;
            
            int x = citiesWithTowers.get(--ptr);
            if (x - limit >= cur || x + limit <= cur) {
                return -1;
            }

            switchCount++;
            cur = x + limit;
        }

        return switchCount;   
    }
}
