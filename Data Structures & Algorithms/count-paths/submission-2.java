class Solution {
    private int findPaths(int m,int n,int x,int y,int dp[][]){
        if (x==m-1 && y==n-1)  return 1;
        if (x>=m || y>=n)  return 0;

        if (dp[x][y]!=-1)  return dp[x][y];
        
        int count=0;
        count+=findPaths(m,n,x+1,y,dp);
        count+=findPaths(m,n,x,y+1,dp);
        return  dp[x][y]=count;
    }
    public int uniquePaths(int m, int n) {
           

        int dp[][]= new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++)  dp[i][j]=-1;
        }
        return findPaths(m,n,0,0,dp);
        
    }
}
