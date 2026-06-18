class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int i=0,j=0;
        int len=Integer.MAX_VALUE;
        int ans=0;
        while(j<nums.length){
            ans+=nums[j];
            while(ans>=target){
                len=Math.min(len,j+1-i);
                ans-=nums[i];
                i++;
            }
            j++;

        }

        return len==Integer.MAX_VALUE ? 0: len;
        
    }
}