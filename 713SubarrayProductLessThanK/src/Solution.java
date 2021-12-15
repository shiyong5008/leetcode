class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int l = nums.length;
        int res = 0;

        for (int i = 0; i < l; ++i) {
            int prod = nums[i];
            int j = i;
            while (prod < k) {
                ++res;
                ++j;
                if (j < l) {
                    prod = prod * nums[j];
                } else {
                    break;
                }
            }
        }
        return res;

    }
}