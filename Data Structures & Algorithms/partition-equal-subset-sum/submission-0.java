class Solution {
    private int findSubset(int []nums,int sum,int len,int dp[][]){
        if (sum==0)  return 1;
        if (len==0)  return 0;
        if (dp[sum][len]!=-1)  return dp[sum][len];

        if (nums[len-1]<=sum){
            int a= findSubset(nums,sum-nums[len-1],len-1,dp);
            if (a==1) return dp[sum][len]=1;
        }

        return dp[sum][len]= findSubset(nums,sum,len-1,dp);
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n= nums.length;
        for (int i=0;i<n;i++) sum+=nums[i];

        if (sum%2!=0)  return false;

        sum=sum/2;
        int dp[][]= new int[sum+1][n+1];
        for (int i=0;i<=sum;i++){
            for (int j=0;j<=n;j++)  dp[i][j]=-1;
        }
        int a= findSubset(nums,sum,n,dp);
        if (a==1)  return true;
        return false;
        
    }
}
