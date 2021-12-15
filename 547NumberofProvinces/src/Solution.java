class Solution {
    public int findCircleNum(int[][] isConnected) {

        int r = isConnected.length;
        int c = isConnected[0].length;
        int count = 0;

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (isConnected[i][j] == 1) {
                    ++count;
                    dfs(isConnected, i, j);
                }
            }
        }
        return count;

    }

    public void dfs(int[][] isConnected, int i, int j) {

        int r = isConnected.length;
        int c = isConnected[0].length;

        isConnected[i][j] = 2;
       

    }
}
