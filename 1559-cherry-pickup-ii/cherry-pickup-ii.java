class Solution {
    public int cherryPickup(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

    ///dp[i][j1][j2].   max cherries collected when r1 is at row i ,j1 and r2 and rowi j2

    int [][][]dp=new int [row][col][col];
    for(int i=0;i<row;i++){
        for(int col1=0;col1<col;col1++){
            for(int col2=0;col2<col;col2++){
                dp[i][col1][col2]=-1;
            }
        }
    }
    dp[0][0][col-1]=grid[0][0]+(0==col-1?0:grid[0][col-1]);

    int []del={-1,0,1};

    for(int i=1;i<row;i++){
        for(int col1=0;col1<col;col1++){
            for(int col2=0;col2<col;col2++){
                int maxval=-1;

                for(int d1:del){
                    for(int d2:del){
                        int prevcol1=col1-d1;
                        int prevcol2=col2-d2;

                        if(prevcol1>=0 && prevcol1<col 
                        && prevcol2>=0 && prevcol2<col 
                        &&dp[i-1][prevcol1][prevcol2]!=-1){
                            //int val=dp[i-1][prevcol1][prevcol2];
                            int chocolates=col1==col2?dp[i-1][prevcol1][prevcol2]+grid[i][col1]:dp[i-1][prevcol1][prevcol2]+grid[i][col1]+grid[i][col2];
                            maxval=Math.max(maxval,chocolates);
                        }


                    }
                }
                dp[i][col1][col2]=maxval;
            }
        }
    }
int ans=-1;

for(int i=0;i<col;i++){
    for(int j=0;j<col;j++){
        if(dp[row-1][i][j]!=-1){
            ans=Math.max(ans,dp[row-1][i][j]);
        }
          
    }
}
return ans;
    }
}