class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int []> dq= new ArrayDeque<>();
        int [] ans=new int[nums.length+1-k];
        int p=0;
        int i=0,n=nums.length;
        for (int j=0;j<n;j++){

            while(!dq.isEmpty() && dq.peekLast()[0]<=nums[j]) dq.pollLast();
            while(!dq.isEmpty() && dq.peekFirst()[1]<i)  dq.pollFirst();

            dq.offerLast(new int[]{nums[j],j});
            if (j-i==k-1){
                ans[p++]=dq.peekFirst()[0];
                i++;
            }

        }

        return ans;
        
    }
}
