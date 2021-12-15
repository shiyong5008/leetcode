class Solution {
    public int numIslands(char[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
        int count = 0;

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (grid[i][j] == '1') {
                    ++count;
                    dfs(grid, i, j);
                }
            }
        }
        return count;

    }

    public void dfs(char[][] grid, int i, int j) {
        int r = grid.length;
        int c = grid[0].length;

        grid[i][j] = '2';

        if (i - 1 >= 0 && grid[i-1][j] == '1') {
            dfs(grid, i-1, j);
        }
        if (i + 1 < r && grid[i+1][j] == '1') {
            dfs(grid, i+1, j);
        }
        if (j - 1 >= 0 && grid[i][j-1] == '1') {
            dfs(grid, i, j-1);
        }
        if (j + 1 < c && grid[i][j+1] == '1') {
            dfs(grid, i, j+1);
        }

    }
}
