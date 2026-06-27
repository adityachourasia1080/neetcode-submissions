class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

       Arrays.sort(intervals,(int a[],int b[])->{
        return Integer.compare(a[1],b[1]);
       });


       int remove=0;
       int cs=intervals[0][0];
       int ce=intervals[0][1];

       for (int i=1;i<intervals.length;i++){

        if (ce>intervals[i][0] && ce<=intervals[i][1]){
            remove++;
        }
        else{
            cs= intervals[i][0];
            ce= intervals[i][1];
        }
       }
       return remove;
        
    }
}
