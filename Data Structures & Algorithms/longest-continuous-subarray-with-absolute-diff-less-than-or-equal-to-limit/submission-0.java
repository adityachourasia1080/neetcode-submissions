class Solution {
    public int longestSubarray(int[] nums, int limit) {

        PriorityQueue<int[]>minh = new PriorityQueue<>((int a[],int b[])->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]>maxh = new PriorityQueue<>((int a[],int b[])->Integer.compare(b[0],a[0]));

        int left=0;
        int right=0;
        int n= nums.length;
        int max=0;
        int min=0;
        int ans=0;

        while(right<n){
            minh.offer(new int[]{nums[right],right});
            maxh.offer(new int[]{nums[right],right});

            while(!minh.isEmpty() && minh.peek()[1]<left)  minh.poll();
            while(!maxh.isEmpty() && maxh.peek()[1]<left) maxh.poll();

            max= maxh.peek()[0];
            min= minh.peek()[0];


            while(max-min>limit){
                left++;
                while(!minh.isEmpty() && minh.peek()[1]<left)  minh.poll();
                while(!maxh.isEmpty() && maxh.peek()[1]<left) maxh.poll();

                max= maxh.peek()[0];
                min= minh.peek()[0];
                
            }
            ans=Math.max(ans, right+1-left);
            right++;
 
        }

        return ans;

        
    }
}