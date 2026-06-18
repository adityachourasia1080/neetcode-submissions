class Solution {
    private int recur(int dp[],int index,int n){
        if (index==n)  return 1;
        if(index>n)  return 0;

        if (dp[index]!=-1)  return dp[index];

        return dp[index]= recur(dp,index+1,n)+ recur(dp,index+2,n);
    }
    public int climbStairs(int n) {
        int dp[]= new int[n+1];
        for (int i=0;i<=n;i++) dp[i]=-1;
        return recur(dp,0,n);
    }
}
