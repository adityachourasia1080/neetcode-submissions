class Solution {
    public int[] minInterval(int[][] intervals, int[] q) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));

        int maxy=Integer.MIN_VALUE;
        int miny=Integer.MAX_VALUE;

        for (int i=0;i<intervals.length;i++){
            miny=Math.min(intervals[i][0],miny);
            maxy=Math.max(intervals[i][1],maxy);
        }

        int arr[]=new int[maxy+1];
        for (int i=0;i<=maxy;i++) arr[i]=-1;

       int k=0;
        for (int i=0;i<=maxy;i++){

           while(k<intervals.length && intervals[k][0]==i){
            pq.offer(new int[]{intervals[k][1]+1-intervals[k][0],intervals[k][0],intervals[k][1]});
            k++;
           }

           while(!pq.isEmpty() && pq.peek()[2]<i){
              pq.poll();
           }

           if (!pq.isEmpty()) arr[i]=pq.peek()[0];
            
        }

        int [] ans= new int[q.length];
        for (int i=0;i<q.length;i++){
            if (q[i]<=maxy) ans[i]=arr[q[i]];
            else ans[i]=-1;
        }

        return ans;

        
    }
}
