class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

       Deque<int[]> dq= new ArrayDeque<>();
        //fixed size window
        int i=0,j=0;
        int[] ans= new int[nums.length+1-k];
        while(j<nums.length){

            while(!dq.isEmpty() && dq.peekFirst()[1]<i) dq.pollFirst();

            while(!dq.isEmpty() && dq.peekLast()[0]<=nums[j]) dq.pollLast();

            dq.offerLast(new int[]{nums[j],j});


            if (j+1-i==k){
                ans[i]=dq.peekFirst()[0];
                i++;
            }
            j++;
        }

        return ans;
        
    }
}
