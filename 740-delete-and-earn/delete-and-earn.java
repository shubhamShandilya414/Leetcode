class Solution {
    public int deleteAndEarn(int[] nums) {
        int []sum=new int[10001];

for(int i:nums){
    sum[i]+=i;
}

int []dp=new int[10001];
dp[1]=sum[1];

for(int i=2;i<10001;i++){
    dp[i]=Math.max(dp[i-1],dp[i-2]+sum[i]);
}
return dp[10000];
    }
}