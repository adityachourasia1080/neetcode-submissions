class Solution {
    private int find(int amount,int[]coins,int n,int dp[][]){
        if (amount==0)  return 1;
        if (n==0)  return 0;

        if (dp[amount][n]!=-1)  return dp[amount][n];
        
        int ways=0;
        if (amount>=coins[n-1]){
            ways= find(amount-coins[n-1],coins,n,dp);
        }
         ways+= find(amount,coins,n-1,dp);
        return dp[amount][n]= ways;
    }
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int dp[][]= new int[amount+1][n+1];
        for (int i=0;i<=amount;i++){
            for (int j=0;j<=n;j++)  dp[i][j]=-1;
        }
        return find(amount,coins,n,dp);
        
    }
}
