class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        long prod=1;
        int count=0;
        int left=0,right=0;
        int n= nums.length;


        while(right<n){
            prod= prod* (long)nums[right];

            while(left<right && prod >= (long)k){
                prod= prod / (long)nums[left];
                left++;
            }

            if (prod< (long)k) count+=right+1-left;
            right++;
        }

        return count;
        
    }
}