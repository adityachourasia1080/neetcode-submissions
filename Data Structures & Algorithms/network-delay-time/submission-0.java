class Solution {
    public int networkDelayTime(int[][] t, int n, int k) {
       int time[]= new int[n+1];
       for (int i=0;i<=n;i++) time[i]=Integer.MAX_VALUE;

       List<List<int []>>adj= new ArrayList<>();
       for (int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
       }

       for (int i=0;i<t.length;i++){
           int u= t[i][0];
           int v= t[i][1];
           int tim= t[i][2];
           adj.get(u).add(new int[]{v,tim});
       }

       time[k]=0;
       PriorityQueue<int[]> pq= new PriorityQueue<>((int a[],int b[])-> Integer.compare(a[0],b[0]));
       pq.offer(new int[]{time[k],k});
       boolean vis[]= new boolean[n+1];

       while(!pq.isEmpty()){
        int temp[]= pq.poll();
        int u= temp[1];
        if(vis[u]==true) continue;
        vis[u]=true;
        int initialTime=temp[0];

         for (int node[]: adj.get(u)){
            int v= node[0];
            int tim= node[1];
            if (vis[v]==false && time[v]>initialTime+tim ){
                time[v]= initialTime+tim;
                pq.add(new int[]{time[v],v});
            }
               
            
         }

       }

       int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (time[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, time[i]);
        }
        return ans;


        
    }
}
