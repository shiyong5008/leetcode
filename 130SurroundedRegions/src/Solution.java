class Solution {
    int m;
    int n;

    public void solve(char[][] board) {

        m = board.length;
        n = board[0].length;
        // if (m == 0) return;

        for (int i = 0; i < m; ++i) {
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }
        for (int j = 1; j < n-1; ++j) {
            dfs(board, 0, j);
            dfs(board, m-1, j);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'F') {
                    board[i][j] = 'O';
                }
            }
        }


    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i > m-1 || j < 0 || j > n-1 || board[i][j] != 'O') return;
        board[i][j] = 'F';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}
