class Solution {
    long dp[][];
    long recur(int[]coins,int amount, int len){
        if (amount==0)  return 0;
        if (len==0)  return Integer.MAX_VALUE;

        if (dp[amount][len]!=-1)  return dp[amount][len];
        
        //dont take
        long temp= recur(coins,amount,len-1);

        //take
        if (amount>=coins[len-1]){
            long temp2= recur(coins,amount-coins[len-1],len);
            if (temp2<Integer.MAX_VALUE) temp = Math.min(temp,temp2+1);
        }

        return dp[amount][len]=temp;
    }

    public int coinChange(int[] coins, int amount) {
        dp= new long[amount+1][coins.length+1];

        for(int i=0;i<=amount;i++){
            for (int j=0;j<=coins.length;j++){
                dp[i][j]=-1;
            }
        }
        long a= recur(coins,amount,coins.length);
        if (a>=Integer.MAX_VALUE)  return -1;
        return (int)a;
        
    }
}
