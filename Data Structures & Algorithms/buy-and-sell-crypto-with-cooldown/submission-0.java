class Solution {
    private int solve(int prices[],int index,boolean bought){
        if (index>=prices.length)  return 0;
        
        int profit=0;
        if (bought){
            profit= prices[index]+solve(prices,index+2,false);
        }
        else{
            profit= solve(prices,index+1,true)-prices[index];
        }

        profit=Math.max(profit,solve(prices,index+1,bought));
        return profit;
    }
    public int maxProfit(int[] prices) {
        // on each day i can Buy/sell/skip that day

        return solve(prices,0,false);
        
    }
}
