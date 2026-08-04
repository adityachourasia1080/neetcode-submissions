class Solution {
    public int swimInWater(int[][] grid) {

        int x[]={1,0,-1,0};
        int y[]={0,1,0,-1};

        // idea
        PriorityQueue<int[]>pq= new PriorityQueue<>((int a[],int b[])->Integer.compare(a[2],b[2]));

        pq.offer(new int[]{0,0,grid[0][0]});
        int n= grid.length;
        int m= grid[0].length;

        while(!pq.isEmpty()){
            int temp[]= pq.poll();
            int cx= temp[0];
            int cy= temp[1];
            int ce= temp[2];

            if (cx==n-1 && cy==m-1)  return  ce;

            if (grid[cx][cy]==-1) continue;
            grid[cx][cy]=-1;


            for (int i=0;i<4;i++){
                int nx= cx+x[i];
                int ny= cy+y[i];

                if (nx<0 || nx>=n || ny<0 || ny>=m || grid[nx][ny]==-1) continue;

                pq.offer(new int[]{nx,ny,Math.max(ce,grid[nx][ny])});

            }
        }


        return 0;

        
    }
}
