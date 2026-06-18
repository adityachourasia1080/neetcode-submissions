class Solution {
    int x[]={1,0,-1,0};
    int y[]={0,1,0,-1};
    private int dfs(int i,int j, int[][]mat,boolean [][]vis,int [][]dp){
        int n= mat.length;
        int m= mat[0].length;
        int ans=0;
        if (dp[i][j]!=-1)return dp[i][j];
        vis[i][j]=true;
        for (int k=0;k<4;k++){
            int nx= x[k]+i;
            int ny= y[k]+j;
            if (nx<0 || nx>=n || ny<0 || ny>=m || vis[nx][ny]==true || (mat[nx][ny]<=mat[i][j])) continue;

            ans= Math.max(ans,dfs(nx,ny,mat,vis,dp)+1);
        }
        dp[i][j]=ans;
        vis[i][j]=false;
        return ans;

    }
    public int longestIncreasingPath(int[][] mat) {

        int n= mat.length;
        int m= mat[0].length;
        boolean vis[][]= new boolean[n][m];
        int dp[][]= new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++)  dp[i][j]=-1;
        }
        int ans=1;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                ans=Math.max(ans,dfs(i,j,mat,vis,dp)+1);
            }
        }

        return ans;
        
    }
}
