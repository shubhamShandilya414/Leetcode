class Solution {
    public int climbStairs(int n) {
        int []dp=new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        return totalWays(0,n,dp);
        
    }

    int totalWays(int curr,int tar,int[]dp){

        if(curr==tar){
            return 1;
        }
        else if(curr>tar){
            return 0;
        }
        int currentkey=curr;

        if(dp[currentkey]!=-1){
            return dp[currentkey];
        }
else{
        int opt1=totalWays(curr+1,tar,dp);
        int opt2=totalWays(curr+2,tar,dp);
dp[currentkey]=  opt1+opt2;
}
return dp[currentkey];
       
    }
}