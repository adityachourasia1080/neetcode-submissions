class Solution {
    public int maxCoins(int[] nums) {
        int n= nums.length;
        int dp[][]= new int[n][n];


        for (int gap=0;gap<n;gap++){

            for (int i=0;i<n-gap;i++){
                int j=i+gap;
                 int ans=0;
                for (int k=i;k<=j;k++){
                    int left= (k==i)? 0 : dp[i][k-1];
                    int right= (k==j) ? 0 : dp[k+1][j];

                    int val = left+right+((i==0) ? 1: nums[i-1])*nums[k]*((j==n-1) ? 1: nums[j+1]);
                    ans= Math.max(ans, val);
                }

                dp[i][j]=ans;
            }
        }

        return dp[0][n-1];
        
    }
}