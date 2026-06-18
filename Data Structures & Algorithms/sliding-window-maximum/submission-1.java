class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<int []>pq= new PriorityQueue<>((int []a,int []b)->Integer.compare(b[0],a[0]));


        //fixed size window
        int i=0,j=0;
        int[] ans= new int[nums.length+1-k];
        while(j<nums.length){

            while(!pq.isEmpty() && pq.peek()[1]<i) pq.poll();

            pq.offer(new int[]{nums[j],j});

            if (j+1-i==k){
                ans[i]=pq.peek()[0];
                i++;
            }
            j++;
        }

        return ans;
        
    }
}
