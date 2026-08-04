class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int x[]={1,0,-1,0};
        int y[]={0,1,0,-1};
        PriorityQueue<int[]>pq=new PriorityQueue<>((int a[],int b[])->Integer.compare(a[2],b[2]));
        pq.offer(new int[]{0,0,0});

        boolean vis[][]=new boolean[heights.length][heights[0].length];

        while(!pq.isEmpty()){

            int temp[]= pq.poll();
            int cx= temp[0];
            int cy= temp[1];
            int cd= temp[2];
           if (cx==heights.length-1 && cy==heights[0].length-1)  return cd;
            if (vis[cx][cy]==true) continue;
            vis[cx][cy]=true;

            for (int i=0;i<4;i++){
                int nx= cx+x[i];
                int ny= cy+y[i];

                if (nx<0 || nx>= heights.length || ny<0 || ny>= heights[0].length || vis[nx][ny]==true) continue;
                pq.add(new int []{nx,ny, Math.max(cd, Math.abs(heights[cx][cy]-heights[nx][ny]))});
            }


        }

        return -1;
        
    }
}