class Solution {
    int x[]={1,0,-1,0};
    int y[]={0,1,0,-1};
    private int dfs(int [][]grid,int i,int j){
        int pathLength=0;
        grid[i][j]=-1;
        for (int k=0;k<4;k++){
            int nx= i+x[k];
            int ny=j+y[k];
            if (nx<0 || nx>=grid.length || ny<0 || ny>=grid[0].length || grid[nx][ny]!=1) continue;
            pathLength+=dfs(grid,nx,ny);
        }

        return pathLength+1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int ans=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==1){
                    ans= Math.max(ans,dfs(grid,i,j));
                }
            }
        }

        return ans;
        
    }
}
