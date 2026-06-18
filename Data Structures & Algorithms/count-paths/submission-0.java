class Solution {
    int x[]={1,0};
    int y[]={0,1};
    private int find(int i,int j,int n,int m,int dp[][],boolean vis[][]){
        if (i==n-1 && j==m-1)  return 1;

        if (dp[i][j]!=-1)  return dp[i][j];
        vis[i][j]=true;

        int ans=0;
        for (int k=0;k<2;k++){
            int nx= x[k]+i;
            int ny= y[k]+j;
            if(nx<0 || nx>=n || ny<0 || ny>=m  || vis[nx][ny]) continue;
            ans+=find(nx,ny,n,m,dp,vis);
        }

        vis[i][j]=false;
        return dp[i][j]=ans;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]= new int[m][n];
        boolean vis[][]= new boolean[m][n];

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                dp[i][j]=-1;
                vis[i][j]=false;
            }
        }

        return find(0,0,m,n,dp,vis);

        
    }
}
