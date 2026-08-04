class Solution {
    public int networkDelayTime(int[][] t, int n, int k) {

        boolean vis[]= new boolean[n+1];
        int dis[]= new int[n+1];
         List<List<int[]>>adj= new ArrayList<>();

        for (int i=0;i<=n;i++) {
            dis[i]=Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }

        for (int i=0;i<t.length;i++){
            int u= t[i][0];
            int v= t[i][1];
            int w= t[i][2];
            adj.get(u).add(new int[]{v,w});
        }
       

        dis[k]=0;
        int time=Integer.MAX_VALUE;

        PriorityQueue<int[]>pq= new PriorityQueue<>((int a[],int b[])->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{k,0});


        while(!pq.isEmpty()){
            int temp[]= pq.poll();
            int u= temp[0];

            if (vis[u]==true) continue;
            vis[u]=true;
            for ( int [] ter: adj.get(u)){
                int v= ter[0];
                int cd= ter[1];

                if (vis[v]==false && dis[v]>dis[u]+ cd)  {
                    dis[v]=dis[u]+cd;
                    pq.offer(new int[]{v,dis[v]});
                }
            }


        }
        time= dis[1];

        for (int i=1;i<=n;i++){
            time= Math.max(time,dis[i]);
        }

        return time==Integer.MAX_VALUE ? -1: time;
        
    }
}
