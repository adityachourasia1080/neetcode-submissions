class Solution {
    public int minimumEffortPath(int[][] h) {
        int n= h.length;
        int m= h[0].length;
        PriorityQueue<int []>pq= new PriorityQueue<>((int a[],int b[])->Integer.compare(a[0],b[0]));
        boolean vis[][]= new boolean[n][m];
         pq.offer(new int[]{0,0,0,});
         

         int x[]={0,1,0,-1};
         int y[]={1,0,-1,0};
        
        while(!pq.isEmpty()){

            int temp[]= pq.poll();
            int cx= temp[1];
            int cy= temp[2];
            if(vis[cx][cy]==true)  continue;
            vis[cx][cy]=true;

            if (cx==n-1 && cy==m-1)  return temp[0];

            for (int i=0;i<4;i++){
                int nx= cx+x[i];
                int ny= cy+y[i];

                if (nx<0 || nx>=n || ny<0 || ny>=m || vis[nx][ny]==true) continue;
                int newdis= Math.abs(h[cx][cy]- h[nx][ny]);
                pq.offer(new int[]{Math.max(newdis,temp[0]), nx,ny});
            }

        }

        return -1;
        
    }
}