class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

        }
        if(sum%2!=0){
            return false;
        }
        else
        return   isPossible(nums,sum/2);
    }
       boolean isPossible(int [] nums,int sum){

        int [][]dp=new int[nums.length+1][sum+1];
       
      // Base case: with only the first element
for (int currSum = 0; currSum <= sum; currSum++) {
    dp[0][currSum] = (nums[0] == currSum) ? 1 : 0;
}

// Any i can make sum = 0 (by picking nothing)
for (int i = 0; i < nums.length; i++) {
    dp[i][0] = 1;
}

   

// think from first principles and write dp transitions.
       for(int i=1;i<nums.length;i++){
        for(int currsum=1;currsum<=sum;currsum++){

           if(nums[i]<=currsum){
            int include=dp[i-1][currsum-nums[i]];
            int exclude=dp[i-1][currsum];
            dp[i][currsum] = (include == 1 || exclude == 1) ? 1 : 0;
           }
           else{
            dp[i][currsum]=dp[i-1][currsum];
           }

        }
       }
       return dp[nums.length-1][sum]==1;
       }
}