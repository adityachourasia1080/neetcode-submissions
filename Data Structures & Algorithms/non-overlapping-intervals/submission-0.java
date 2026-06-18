class Solution {
    public int eraseOverlapIntervals(int[][] it) {
        Arrays.sort(it,((int[]a ,int []b)-> Integer.compare(a[1],b[1])));
        int start=it[0][0];
        int end= it[0][1];
        int count=0;
        for (int i=1;i<it.length;i++){
            int currStart=it[i][0];
            int currEnd= it[i][1];
            if (currStart >=end){
                start=currStart;
                end=currEnd;
            }
            else count++;

        }

        return count;
        
    }
}
