class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>>adj= new ArrayList<>();
        for (int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for (int i=0;i<edges.length;i++){
            int u= edges[i][0];
            int v= edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int []vis = new int[n];
        for (int i=0;i<n;i++) vis[i]=0;

        Queue<Integer> q= new LinkedList<>();
        int count=0;
        for (int i=0;i<n;i++){
            if (vis[i]==0){
                count++;
                vis[i]=1;
                q.add(i);
                while(!q.isEmpty()){
                    int u= q.poll();
                    for (int v: adj.get(u)){
                        if (vis[v]==0){
                            vis[v]=1;
                            q.add(v);
                        }
                    }
                }
            }
        }

        return count;


    }
}
