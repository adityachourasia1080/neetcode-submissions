class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n= s1.length();
        int m= s2.length();
        int dp[][] = new int[2][m+1];
         int index=0;
        for (int i=0;i<=n;i++){
            for (int j=0;j<=m;j++){
                index= i%2;
                if (i==0 || j==0) {
                    dp[index][j]=0;
                    continue;
                }
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[index][j]=1+dp[1-index][j-1];
                }
                else{
                    dp[index][j]=Math.max(dp[1-index][j],dp[index][j-1]);
                }
            }
        }
        return dp[index][m];
        
    }
}
