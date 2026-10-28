class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int start=0;

        int sum=0;
        int ans=Integer.MAX_VALUE;

        for (int i=0;i<nums.length;i++){
            sum+=nums[i];

            while(start<=i && sum>=target){
                ans=Math.min(ans, i-start+1);
                sum=sum-nums[start];
                start++;
            }
        }

        if (ans==Integer.MAX_VALUE)  return 0;
        return ans;
        
    }
}