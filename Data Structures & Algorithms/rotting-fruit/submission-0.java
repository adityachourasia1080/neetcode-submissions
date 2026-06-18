class Solution {
    int x[]={1,0,-1,0};
    int y[]={0,1,0,-1};
    public int orangesRotting(int[][] grid) {
        Queue<int[]>q= new LinkedList<>();
        int n= grid.length;
        int m= grid[0].length;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==2) q.offer(new int[]{i,j});
            }
        }

        int count=0;
        while(!q.isEmpty()){
            int len= q.size();
            boolean move=false;
            for(int i=0;i<len;i++){
             int temp[]= q.poll();
             int ox= temp[0];
             int oy= temp[1];
             for (int k=0;k<4;k++){
                int nx= ox+x[k];
                int ny= oy+y[k];
                if(nx<0 || nx>=n || ny<0 || ny>=m || grid[nx][ny]!=1) continue;
                grid[nx][ny]=2;
                move=true;
                q.add(new int[]{nx,ny});
             }
            }

            if (move) count++;
            
            
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++) {
                if (grid[i][j]==1)  return -1;
            }
        }

        return count;
        
    }
}
