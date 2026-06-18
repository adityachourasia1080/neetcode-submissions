class Solution {
    private int recursive(String s1,String s2,String s3,int n,int m ,int p,int dp[][]){
        if (p==0)  return 1;
        if (dp[n][m]!=-1)  return dp[n][m];

        if (n!=0 && s1.charAt(n-1)==s3.charAt(p-1)){
            int ans=recursive(s1,s2,s3,n-1,m,p-1,dp);
            if (ans==1)  return dp[n][m]=1;
        } 
        if (m!=0 && s2.charAt(m-1)==s3.charAt(p-1) ) {
            int ans=recursive(s1,s2,s3,n,m-1,p-1,dp);
            if (ans==1)  return dp[n][m]=1;

        }

        return dp[n][m]=0;

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int n= s1.length(),m=s2.length(),p=s3.length();
        if (n+m !=p)  return false;

        int dp[][]=new int[n+1][m+1];
        for (int i=0;i<=n;i++){
            for (int j=0;j<=m;j++) dp[i][j]=-1;
        }

        int ans= recursive(s1,s2,s3,n,m,p,dp);
        if (ans==1)  return true;
        return false;
        
    }
}
