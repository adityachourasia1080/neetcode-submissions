class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int []lis= new int[n];
        for (int i=0;i<n;i++) lis[i]=1;
        int ans=1;

        for (int i=1;i<n;i++){
            int j=i-1;
            while(j>=0){
                if (nums[i]>nums[j] && lis[i]<lis[j]+1){
                    lis[i]=lis[j]+1;
                    ans=Math.max(ans,lis[i]);
                }
                j--;
            }
        }

        return ans;
        
    }
}
