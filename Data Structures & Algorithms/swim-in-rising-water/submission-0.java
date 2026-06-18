class Solution {
    int x[]={1,0,-1,0};
    int y[]={0,1,0,-1};
    int n;

    private int dfs(int i,int j,int grid[][],boolean vis[][]){
        if (i== n-1 && j== n-1){
            return grid[n-1][n-1];
        }
        vis[i][j]=true;

        int min=Integer.MAX_VALUE;

        for (int k=0;k<4;k++){
            int nx= x[k]+i;
            int ny=y[k]+j;
            if (nx<0 || nx>=n || ny<0 || ny>=n || vis[nx][ny])   continue;
            min= Math.min(min,dfs(nx,ny,grid,vis));

        }
        vis[i][j]=false;
        return Math.max(min,grid[i][j]);
    }
    public int swimInWater(int[][] grid) {
         n= grid.length;
        boolean vis[][]= new boolean[n][n];
        return dfs(0,0,grid,vis);
        
    }
}
