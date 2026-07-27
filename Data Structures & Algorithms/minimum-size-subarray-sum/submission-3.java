class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left=0;
        int right=0;
        int ans=Integer.MAX_VALUE;

        int n= nums.length;
        int total=0;

        while(right<n){
            total+=nums[right];

            while(total>=target){
                ans=Math.min(ans, right+1-left);
                total-=nums[left];
                left++;
            }

            right++;

        }

        return ans==Integer.MAX_VALUE ? 0: ans;
        
    }
}