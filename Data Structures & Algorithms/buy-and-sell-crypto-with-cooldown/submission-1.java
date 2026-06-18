class Solution {
    private int solve(int prices[],int index,int bought,int dp[][]){
        if (index>=prices.length)  return 0;
        if (dp[index][bought]!=-1)  return dp[index][bought];
        
        int profit=0;
        if (bought==1){
            profit= prices[index]+solve(prices,index+2,0,dp);
        }
        else{
            profit= solve(prices,index+1,1,dp)-prices[index];
        }

        profit=Math.max(profit,solve(prices,index+1,bought,dp));
        return dp[index][bought]=profit;
    }
    public int maxProfit(int[] prices) {
        // on each day i can Buy/sell/skip that day
        int dp[][]= new int[prices.length+1][2];
        for (int i=0;i<=prices.length;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return solve(prices,0,0,dp);
        
    }
}
