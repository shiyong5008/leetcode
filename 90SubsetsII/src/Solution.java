import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return lists;

    }

    public void dfs(boolean choose, int index, int[]nums) {
        if (index == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        dfs(false, index+1, nums);
        if (!choose && index > 0 && nums[index] == nums[index-1]) {
            return;
        }

        list.add(nums[index]);
        dfs(true, index+1, nums);
        list.remove(list.size()-1);
        // dfs(false, index+1, nums);

    }
}
