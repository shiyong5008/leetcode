import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
        if (n == 1) return 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        grid[0][0] = 2;
        int minPath = 1;

        while(!q.isEmpty()) {
            int qs = q.size();
            for (int i = 0; i < qs; ++i) {
                int[] pop = q.poll();
                int r = pop[0], c = pop[1];
                if (r == n-1 && c == n-1) return minPath;

                if (r-1 >=0 && c-1 >=0 && grid[r-1][c-1] == 0) {
                    q.add(new int[]{r-1,c-1});
                    grid[r-1][c-1] = 2;
                }
                if (r-1 >=0 && grid[r-1][c] == 0) {
                    q.add(new int[]{r-1,c});
                    grid[r-1][c] = 2;
                }
                if (r-1 >=0 && c+1 < n && grid[r-1][c+1] == 0) {
                    q.add(new int[]{r-1,c+1});
                    grid[r-1][c+1] = 2;
                }
                if (c+1 < n && grid[r][c+1] == 0) {
                    q.add(new int[]{r,c+1});
                    grid[r][c+1] = 2;
                }
                if (r+1 < n && c+1 < n && grid[r+1][c+1] == 0) {
                    q.add(new int[]{r+1,c+1});
                    grid[r+1][c+1] = 2;
                }
                if (r+1 < n && grid[r+1][c] == 0) {
                    q.add(new int[]{r+1,c});
                    grid[r+1][c] = 2;
                }
                if (r+1 < n && c-1 >=0 && grid[r+1][c-1] == 0) {
                    q.add(new int[]{r+1,c-1});
                    grid[r+1][c-1] = 2;
                }
                if (c-1 >=0 && grid[r][c-1] == 0) {
                    q.add(new int[]{r,c-1});
                    grid[r][c-1] = 2;
                }
            }
            ++minPath;
        }
        return -1;

    }
}
