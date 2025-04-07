class Solution {
    public int rob(int[] nums) {
    if (nums.length == 1) return nums[0]; // edge case

    return Math.max(
        helper(nums, 0, nums.length - 2),  // exclude last house
        helper(nums, 1, nums.length - 1)   // exclude first house
    );
}

private int helper(int[] nums, int start, int end) {
    if (start == end) return nums[start]; // 

    int[] dp = new int[end + 1];
    dp[start] = nums[start];
    dp[start + 1] = Math.max(nums[start], nums[start + 1]);

    for (int i = start + 2; i <= end; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }

    return dp[end];
}

}