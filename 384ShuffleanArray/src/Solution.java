import java.util.Random;

class Solution {

    int[] nums;
    int[] original;

    public Solution(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);

    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length);
        return nums;

    }

    public int[] shuffle() {
        Random ran = new Random();
        for (int i = 0; i < nums.length; ++i) {
            int j = i + ran.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
