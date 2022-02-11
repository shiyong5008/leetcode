import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return lists;

    }

    public void dfs(int index, int[] nums) {
        if (index == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs(index+1, nums);
        list.remove(list.size()-1);
        dfs(index+1, nums);

    }

}
