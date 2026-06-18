class Solution {

    private int editDistance(String word1,String word2,int n,int m,int dp[][]){
         if (n==0 && m==0)   return 0;
         if (n==0)  return m;
         if (m==0)   return n;

         if (dp[n][m]!=-1)  return dp[n][m];

         if (word1.charAt(n-1)== word2.charAt(m-1)){
            return  dp[n][m]=editDistance(word1,word2,n-1,m-1,dp);
         }

         return dp[n][m]=1+Math.min(editDistance(word1,word2,n-1,m,dp),
                  Math.min(editDistance(word1,word2,n,m-1,dp),editDistance(word1,word2,n-1,m-1,dp)));
    }

    public int minDistance(String word1, String word2) {

        int n= word1.length();
        int m = word2.length();

        int dp[][]= new int[n+1][m+1];
        for (int i=0;i<=n;i++){
            for (int j=0;j<=m;j++)  dp[i][j]=-1;
        }

        return editDistance(word1,word2,n,m,dp);
        
    }
}
