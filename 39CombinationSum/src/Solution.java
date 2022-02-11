import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return lists;
    }

    public void dfs(int[] candidates, int target, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        dfs(candidates, target, idx+1);
        if (target - candidates[idx] >= 0) {
            list.add(candidates[idx]);
            dfs(candidates, target-candidates[idx], idx);
            list.remove(list.size()-1);
        }
    }

}
