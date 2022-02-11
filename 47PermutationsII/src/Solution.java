import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    boolean[] choose;

    public List<List<Integer>> permuteUnique(int[] nums) {
        choose = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(0, choose, nums);
        return lists;

    }

    public void dfs(int index, boolean[] choose, int[] nums) {
        if (index == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (choose[i] || (i > 0 && !choose[i-1] && nums[i] == nums[i-1])) {
                continue;
            }
            list.add(nums[i]);
            choose[i] = true;
            dfs(index+1, choose, nums);
            choose[i] = false;
            list.remove(list.size()-1);
        }

    }

}
