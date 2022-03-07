import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0);

        int n = lists.size();
        if (n == 0) return -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int m = lists.get(i).size();
            if (m < min) min = m;
        }
        return min;

    }

    public void dfs(int[] coins, int amount, int idx) {
        if (idx == coins.length) {
            return;
        }
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        dfs(coins, amount, idx+1);
        if (amount - coins[idx] >= 0) {
            list.add(coins[idx]);
            dfs(coins, amount - coins[idx], idx);
            list.remove(list.size()-1);
        }
    }

}

 */


class Solution {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }
}