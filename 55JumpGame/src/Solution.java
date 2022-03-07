/*
class Solution {
    public boolean canJump(int[] nums) {

        // if (nums[0] == 0) return false;
        int n = nums.length;
        int[] max = new int[n];
        max[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (max[i-1] >= i) {
                max[i] = Math.max(max[i-1], nums[i]+i);
            } else {
                return false;
            }
        }
        return true;

    }
}

 */

class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;
        int max = nums[0];
        for (int i = 1; i < n; ++i) {
            if (max >= i) {
                max = Math.max(max, nums[i]+i);
            } else {
                return false;
            }
        }
        return true;

    }
}
