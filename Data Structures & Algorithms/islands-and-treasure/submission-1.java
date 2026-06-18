class Solution {
    int x[]={1,0,-1,0};
    int y[]={0,1,0,-1};
    public void islandsAndTreasure(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        boolean vis[][]= new boolean[n][m];

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==0){
                  q.offer(new int[]{i,j,0});
                  vis[i][j]=true;
                }
            }
        }


        while(!q.isEmpty()){
            int temp[]= q.poll();
             int dis= temp[2];
            int i=temp[0];
            int j=temp[1];

            for (int k=0;k<4;k++){
                int nx=x[k]+i;
                int ny= y[k]+j;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] == -1 || vis[nx][ny]) continue;

                vis[nx][ny]=true;
                q.offer(new int[]{nx,ny,dis+1});
                grid[nx][ny]=dis+1;
            }
        }
        
    }
}
