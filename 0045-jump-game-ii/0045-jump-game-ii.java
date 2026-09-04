class Solution {
    int n;
    int[] dp;
    public int solve(int[] nums, int i) {
        if (i >= n - 1) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[i]; j++) {
            int jumps = solve(nums, i + j);
            if (jumps != Integer.MAX_VALUE) {
                min = Math.min(min, jumps + 1);
            }
        }
        return dp[i] = min;
    }
    public int jump(int[] nums) {
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, 0);
    }
}