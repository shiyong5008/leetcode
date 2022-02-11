import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return lists;

    }

    public void dfs(int[] candidates, int target, int idx) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < candidates.length; ++i) {
            if (i > idx && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (target - candidates[i] >= 0) {
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], i+1);
                list.remove(list.size()-1);
            } else {
                break;
            }
        }

    }
}
