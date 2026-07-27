class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);
        int left=0;
        int right=0;
        long total=0;
        int n= nums.length;
        int ans=0;


        while(right<n){
            total+=nums[right];

            while(nums[right]*(right-left+1L)>total+k){
                total-=nums[left];
                left++;
            }

            ans= Math.max(ans,right-left+1);
            right++;
        }

        return ans;
        
    }
}