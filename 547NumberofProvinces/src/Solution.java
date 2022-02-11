class Solution {
    public int findCircleNum(int[][] isConnected) {

        int r = isConnected.length;
        boolean[] visited = new boolean[r];
        int count = 0;

        for (int i = 0; i < r; ++i) {
            if (!visited[i]) {
                ++count;
                dfs(isConnected, visited, i);
            }
        }
        return count;

    }

    public void dfs(int[][] isConnected, boolean[] visited, int i) {

        int r = isConnected.length;
        for (int j = 0; j < r; ++j) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }

    }
}
