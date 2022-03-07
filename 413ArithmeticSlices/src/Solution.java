class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        int n = nums.length;
        if (n < 3) return 0;

        int d = nums[0] - nums[1];
        int t = 0;
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (nums[i-1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i-1] - nums[i];
                t = 0;
            }
            ans = ans + t;
        }
        return ans;

    }
}
