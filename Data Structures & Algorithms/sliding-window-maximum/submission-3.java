class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {


        PriorityQueue<int []>pq= new PriorityQueue<>((int a[],int b[])->Integer.compare(b[0],a[0]));

        int i=0,j=0;
        int n= nums.length;

        int [] ans= new int[n+1-k];
        int t=0;

        while(j<n){
            pq.offer(new int[]{nums[j],j});
            while(!pq.isEmpty() && pq.peek()[1]<i) pq.poll();

            if (j+1>=k){
               ans[t++]= pq.peek()[0];
               i++;
            }
            j++;

        }

        return ans;
        
    }
}
