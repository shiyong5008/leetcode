class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        /* fail
        int n = nums.length;
        int sum = nums[0];
        int count = 1;
        if (sum >= target) return count;
        int min = n;
        for (int i = 1; i < n; ++i) {
            int j = i;
            while (sum < target) {
                sum = sum + nums[j];
                ++j;
                ++count;
                if (count == n && sum < target) {
                    return 0;
                }
                if (j == n) {
                    break;
                }
            }
            if (min > count) {
                min = count;
            }
            sum = nums[i];
            count = 1;
        }
        return min;

         */

        int n = nums.length;
        int min = n;
        int sum = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        while (j < n) {
            while (sum < target) {
                sum = sum + nums[j];
                ++count;
                ++j;
                if (count == n && sum < target) {
                    return 0;
                }
                if (j == n) break;
            }
            if (min > count) {
                min = count;
            }
            while (sum >= target) {
                sum = sum - nums[i];
                --count;
                ++i;
            }
            if (min > count + 1) {
                min = count + 1;
            }
        }
        return min;

    }
}
