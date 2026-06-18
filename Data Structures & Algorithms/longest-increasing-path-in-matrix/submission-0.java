class Solution {
    int x[]={1,0,-1,0};
    int y[]={0,1,0,-1};
    private int dfs(int i,int j, int[][]mat,boolean [][]vis){
        vis[i][j]=true;
        int n= mat.length;
        int m= mat[0].length;
        int ans=0;
        for (int k=0;k<4;k++){
            int nx= x[k]+i;
            int ny= y[k]+j;
            if (nx<0 || nx>=n || ny<0 || ny>=m || vis[nx][ny]==true || (mat[nx][ny]<=mat[i][j])) continue;

            ans= Math.max(ans,dfs(nx,ny,mat,vis)+1);
        }
         vis[i][j]=false;
        return ans;

    }
    public int longestIncreasingPath(int[][] mat) {

        int n= mat.length;
        int m= mat[0].length;
        boolean vis[][]= new boolean[n][m];
        int ans=1;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                ans=Math.max(ans,dfs(i,j,mat,vis)+1);
            }
        }

        return ans;
        
    }
}
