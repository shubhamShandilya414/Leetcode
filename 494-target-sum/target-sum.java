class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       return helper(0,0,nums,target);
    }

    int helper(int currindex,int currsum,int[]nums,int tar){
        if(currindex==nums.length && currsum==tar){
            return 1;
        }
        else if(currindex==nums.length && currsum!=tar){
            return 0;
        }
        int add=helper(currindex+1,currsum+nums[currindex],nums,tar);
        int minus=helper(currindex+1,currsum-nums[currindex],nums,tar);
return add+minus;
    }
}