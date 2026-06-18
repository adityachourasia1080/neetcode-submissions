class Solution {
    int x[]={1,0,-1,0};
    int y[]={0,1,0,-1};
    public int minimumEffortPath(int[][] h) {
        int n= h.length;;
        int m=h[0].length;
      PriorityQueue<int[]> pq =new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        boolean vis[][]= new boolean[n][m];

        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){

            int []temp= pq.poll();
            int i=temp[1];
            int j=temp[2];
            if(i==n-1 && j==m-1)  return temp[0];
            if (vis[i][j]==true) continue;
            vis[i][j]=true;

            for (int k=0;k<4;k++){
                int nx = x[k]+i;
                int ny = y[k]+j;
                if (nx<0 || nx>=n || ny<0 || ny>=m || vis[nx][ny]==true) continue;
                pq.offer(new int[]{Math.max(temp[0],Math.abs(h[i][j]-h[nx][ny])),nx,ny});

            }
        }

        return -1;

        
    }
}