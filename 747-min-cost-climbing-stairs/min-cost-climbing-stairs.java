class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int []dp=new int [cost.length+1];
        dp[0]=cost[0];

        if(cost.length>0){
            dp[1]=Math.min(cost[1],dp[0]+cost[1]);
        }
        for(int i=2;i<cost.length;i++){

            int cost1=dp[i-2]+cost[i];
            int cost2=dp[i-1]+cost[i];

            dp[i]=Math.min(cost1,cost2);
        }

        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}