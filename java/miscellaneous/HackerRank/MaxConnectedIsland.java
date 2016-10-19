import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxConnectedIsland {

    final int n;
    final int m;
        
    public MaxConnectedIsland(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        MaxConnectedIsland island = new MaxConnectedIsland(n, m);
        assert(island.countIslands(grid) == 2);
        assert(island.maxIslandArity(grid) == 5);
    }

    boolean isSafe(int[][] grid,
                   int i,
                   int j,
                   boolean[][] visited) {
        return (i >= 0) && (i < this.n) &&
            (j >= 0) && (j < this.m) &&
            (grid[i][j] == 1) && (!visited[i][j]);
    }

    // returns max count of subtree
    int dfs(int[][] grid,
             int i,
             int j,
             boolean[][] visited) {
        
        int[] rowNbr = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
        int[] colNbr = new int[] {1, 1, 0, -1, -1, -1, 0, 1};
        visited[i][j] = true;
        int count = 1;
        
        for (int k = 0; k < 8; k++) {
            if (isSafe(grid, i + rowNbr[k], j + colNbr[k], visited)) {
                count += dfs(grid, i + rowNbr[k], j + colNbr[k], visited);
            }
        }

        return count;
    }
    
    public int countIslands(int[][] grid) {

        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    public int maxIslandArity(int[][] grid) {

        boolean[][] visited = new boolean[n][m];
        int arity = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int count = dfs(grid, i, j, visited);
                    if (arity < count) {
                        arity = count;
                    }
                }
            }
        }

        return arity;
    }

    public void toString(int[][] grid) {
        for (int[] arr : grid) {
            System.out.println(Arrays.toString(arr));
        }
    }
    
}
