class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n= cost.length;
        int first=0,second=0;
        int ans=0;

        for (int i=2;i<=n;i++){
            int temp1= first+cost[i-2];
            int temp2= second+cost[i-1];
            ans=Math.min(temp1,temp2);
            first= second;
            second= ans;
        }

        return ans;
        
    }
}
