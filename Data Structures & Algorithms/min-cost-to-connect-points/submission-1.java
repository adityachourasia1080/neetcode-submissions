class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n= points.length;
        boolean vis[]= new boolean[n];
        List<List<int[]>>adj= new ArrayList<>();

        int dis[]= new int[n];

        for (int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            dis[i]=Integer.MAX_VALUE;
        }
        

        int res=0;

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i==j) continue;

                int d= Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                adj.get(i).add(new int[]{j,d});
                adj.get(j).add(new int[]{i,d});
            }
        }

        PriorityQueue<int[]>pq= new PriorityQueue<>((int a[],int b[])->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{0,0});


        while(!pq.isEmpty()){
            int temp[]= pq.poll();
            int index= temp[0];
            int cx= points[index][0];
            int cy= points[index][1];

            if (vis[index]==true) continue;
            vis[index]=true;
            res+=temp[1];

            for (int ter[]: adj.get(index)){
                int nindex= ter[0];
                int nx= points[nindex][0];
                int ny= points[nindex][1];

                if (vis[nindex]==false && dis[nindex]> ter[1]){
                    dis[index]=ter[1];
                    pq.offer(new int[]{nindex,dis[index]});
                }
            }
        }


        return res;

        
    }
}
