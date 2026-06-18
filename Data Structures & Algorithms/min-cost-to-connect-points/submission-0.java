class Solution {
    public int minCostConnectPoints(int[][] points) {

        ArrayList<ArrayList<int[]>> adj= new ArrayList<>();
        int n= points.length;

        // initilization 
        boolean vis[]= new boolean[n];
        for (int i=0;i<n;i++){ adj.add(new ArrayList<>());}

        //forming adj matrix
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i==j) continue;
                int dis= Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                adj.get(i).add(new int[]{dis,j});
            }
        }

        //spanning tree using prims algo
        PriorityQueue<int[]> pq= new PriorityQueue<>((int a[],int b[])->{
            return Integer.compare(a[0],b[0]);
        });

        pq.offer(new int[]{0,0});
        int ans=0;

        while(!pq.isEmpty()){
            int temp[]= pq.poll();
            int u= temp[1];
            int dis=temp[0];
            if (vis[u]) continue;
            
            ans+= dis;
            vis[u]=true;

            for (int [] t: adj.get(u)){
               int v= t[1];
               if (!vis[v]){
                pq.offer(new int[]{t[0],t[1]});
               }
            }
        }

        return ans;

        
        
    }
}
