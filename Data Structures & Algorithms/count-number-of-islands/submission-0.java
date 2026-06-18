class Solution {
    int[][]dir= {{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(char[][]grid,int x,int y){
        grid[x][y]='#';
        for (int[]temp:  dir){
             int nx= x+temp[0];
             int ny= y+temp[1];

             if (nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]=='1'){
                dfs(grid,nx,ny);
             }
        }

    }
    public int numIslands(char[][] grid) {

        ArrayList<int[]>q= new ArrayList<>();
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1') q.add(new int[]{i,j});
            }
        }
        int count=0;
        for (int i=0;i<q.size();i++){
            int temp[]= q.get(i);
            int x= temp[0];
            int y= temp[1];
            if (grid[x][y]=='#') continue;

            dfs(grid,x,y);
            count++;

        }
        return count;

        
    }
}
