class Solution {
    int x[]= {1,0,-1,0};
    int y[]= {0,1,0,-1};
    public int swimInWater(int[][] grid) {
        int n= grid.length;
       PriorityQueue<int[]> minh = new PriorityQueue<>(
       (int[] a, int[] b) -> Integer.compare(a[0], b[0])
         );


        minh.offer(new int[]{grid[0][0],0,0});
        boolean vis[][]= new boolean[n][n];

        while(!minh.isEmpty()){
            int temp[]= minh.poll();
            int i=temp[1];
            int j= temp[2];
            vis[i][j]=true;
            if (i==n-1 &&  j==n-1){
                return temp[0];
            }

            for (int k=0;k<4;k++){
                int nx=i+x[k];
                int ny=j+y[k];
                if (nx<0 || nx>=n || ny<0 || ny>=n || vis[nx][ny]) continue;
                int sec= Math.max(temp[0],grid[nx][ny]);
                minh.offer(new int[]{sec,nx,ny});
            }
        }

        return -1;


        
    }
}
