class Solution {
    private int recur(int[]nums,int index,int[]dp){
        if (index==nums.length-1)  return 1;
        if (index>=nums.length)  return 0;

        if (dp[index]!=-1)  return dp[index];

        int jump= index+nums[index];
        for (int j=index+1;j<=jump;j++){
            int temp =recur(nums,j,dp);
            if (temp==1)  {
                dp[index]=1;
                return 1;
            }
        }

        dp[index]=0;
        return 0;
    }
    public boolean canJump(int[] nums) {
        int n= nums.length;
        int dp[]= new int[n];
        for (int i=0;i<n;i++) dp[i]=-1;

        recur(nums,0,dp);
        return dp[0]==0 ? false: true;
    }
}
