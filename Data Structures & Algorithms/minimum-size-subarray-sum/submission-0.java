class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n= nums.length;
        int j=0,i=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;

        while(j<n){
           sum+=nums[j];
           
           while(i<=j && sum>=target){
                if (sum>=target){
                ans=Math.min(ans,j+1-i);
                sum=sum-nums[i];
                 i++;
                }
           }

           j++;
        }

        if (ans==Integer.MAX_VALUE)  return 0;
        return ans;
        
    }
}