class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]>res=new ArrayList<>();

        int []currinterval=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=currinterval[1]){
                currinterval[1]=Math.max(currinterval[1],intervals[i][1]);
            }
            else{
                res.add(currinterval);
                currinterval=intervals[i];
            }
        }

res.add(currinterval);
return res.toArray(new int[res.size()][]);
    }
}