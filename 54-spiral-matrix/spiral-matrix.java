class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;

        int r=0,c=0;
        int [][]vis=new int [row][col];
       
        List<Integer>res=new ArrayList<>();       
        int dr[]={0,1,0,-1};
        int dc[]={1,0,-1,0};
        int dir=0;

        for(int i=0;i<row*col;i++){
            res.add(matrix[r][c]);
            vis[r][c]=1;

            int newr=r+dr[dir];
            int newc=c+dc[dir];

            if(0<=newr && newr<row && 0<=newc && newc<col && vis[newr][newc]==0){

                r=newr;
                c=newc;

            }
            else{
                dir=(dir+1)%4;
                r=r+dr[dir];
                c=c+dc[dir];
            }


        }


return res;
    }
}