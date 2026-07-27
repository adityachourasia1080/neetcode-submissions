class Solution {
    public int longestOnes(int[] nums, int k) {

        int ans=0;
        int left=0;
        int right=0;
        int zero=0;
        int n= nums.length;

        while(right<n){
            if(nums[right]==0)   zero++;

            while(zero>k){
                if (nums[left]==0)  zero--;
                left++;
            }

            ans=Math.max(ans, right+1-left);
            right++;

        }

        return ans;
        
    }
}