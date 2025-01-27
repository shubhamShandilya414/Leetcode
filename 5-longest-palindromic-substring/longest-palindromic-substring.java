class Solution {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return " ";
        }

        int n=s.length();
        boolean [][]dp=new boolean [n][n];
        int start=0;
        int maxlength=1;


        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
            //solve for substring opf length 2;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                maxlength=2;
                start=i;
            }
        }

        for(int len=3;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                 int j=i+len-1;
                   if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                    dp[i][j]=true;
                    if(len>maxlength){
                    start=i;
                    maxlength=len;
                    }
                   }

            }
        }

        return s.substring(start,start+maxlength);

    }
}