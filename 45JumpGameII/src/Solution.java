class Solution {
    public int jump(int[] nums) {

        int n = nums.length;

        int step = 0;
        int maxPos = 0;
        int end = 0;

        for (int i = 0; i < n-1; ++i) {
            maxPos = Math.max(maxPos, i+nums[i]);
            if (i == end) {
                end = maxPos;
                ++step;
            }  // if index reach the end, that need update the maxPos, ++step.
        }
        return step;
    }
}
