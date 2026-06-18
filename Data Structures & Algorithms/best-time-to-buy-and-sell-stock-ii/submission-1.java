class Solution {
    private int solve(int prices[],int l,int buy,int dp[][]){
        if (l==prices.length)  return 0;
        if (dp[l][buy]!=Integer.MIN_VALUE)  return dp[l][buy];

        int ans= solve(prices,l+1,buy,dp);

        if (buy==1){
           ans=Math.max(ans,solve(prices,l+1,1-buy,dp)-prices[l]);
        }
        else{
            ans=Math.max(ans,solve(prices,l+1,1-buy,dp)+prices[l]);
        }

        return dp[l][buy] = ans;
    }
    public int maxProfit(int[] prices) {
        int dp[][]= new int[30002][2];
        for (int i=0;i<30002;i++){
            dp[i][0]=Integer.MIN_VALUE;
            dp[i][1]= Integer.MIN_VALUE;
        }
        return solve(prices,0,1,dp);
        
    }
}