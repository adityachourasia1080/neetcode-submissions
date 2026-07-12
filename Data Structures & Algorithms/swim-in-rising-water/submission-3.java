class Solution {
    public int swimInWater(int[][] grid) {

        int []x={1,0,-1,0};
        int y[]={0,1,0,-1};

        PriorityQueue<int []>pq= new PriorityQueue<>((int a[],int b[])-> Integer.compare(a[0],b[0]));
        pq.add(new int[]{grid[0][0],0,0});

        
        int n= grid.length;
        int m= grid[0].length;

        while(!pq.isEmpty()){
            int [] temp= pq.poll();
            int currTime= temp[0];
            int cx= temp[1];
            int cy= temp[2];

            if (grid[cx][cy]==-1) continue;
            grid[cx][cy]=-1;
            if (cx==n-1 && cy==m-1){
                return currTime;
            }

            for (int i=0;i<4;i++){
                int nx= x[i]+cx;
                int ny= y[i]+cy;
                if (nx<0 || nx>=n || ny<0 || ny>=m || grid[nx][ny]==-1) continue;

                
                pq.add(new int[]{Math.max(temp[0], grid[nx][ny]),nx,ny});
            }
            

        }

        return -1;

        
        
    }
}
