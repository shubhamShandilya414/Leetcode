import java.util.*;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If sum is odd, we cannot partition it into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        // Memoization map: (index, currSum) -> result
        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];

        return helper(0, nums, sum / 2, 0, dp);
    }

    private boolean helper(int index, int[] nums, int target, int currSum, Boolean[][] dp) {
        // If we reach the exact target, return true
        if (currSum == target) {
            return true;
        }

        // If index is out of bounds or sum exceeds target, return false
        if (index >= nums.length || currSum > target) {
            return false;
        }

        // If already computed, return the stored result
        if (dp[index][currSum] != null) {
            return dp[index][currSum];
        }

        // Include current element or skip it
        boolean include = helper(index + 1, nums, target, currSum + nums[index], dp);
        boolean exclude = helper(index + 1, nums, target, currSum, dp);

        // Store result in memoization table
        dp[index][currSum] = include || exclude;
        return dp[index][currSum];
    }
}
