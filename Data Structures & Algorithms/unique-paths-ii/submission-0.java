class Solution {
    int x[]={1,0};
    int y[]={0,1};

    private int backtrack(int [][]grid,int dp[][],int a,int b){
        int n= grid.length;
        int m= grid[0].length;
        if (a==n-1  && b==m-1)  return 1;
        if (dp[a][b]!=-1)  return dp[a][b];
        int count=0;
        for (int i=0;i<2;i++){
            int nx= a+x[i];
            int ny= b+y[i];

            if (nx>=n || ny>=m || grid[nx][ny]==1) continue;

            count+=backtrack(grid,dp,nx,ny);
        }

        return dp[a][b]=count;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;

        int dp[][]= new int[n+1][m+1];
        for (int i=0;i<=n;i++){
            for (int j=0;j<=m;j++)  dp[i][j]=-1;
        }

        if (grid[n-1][m-1]==1 || grid[0][0]==1)  return 0;


        return backtrack(grid,dp,0,0);
        
    }
}