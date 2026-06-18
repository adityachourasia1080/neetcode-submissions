class Solution {
    public boolean validTree(int n, int[][] edges) {
        // since tree we have to chekc only cycle in graph
        // if graph does not have a cycle it is tree

        if (edges.length ==0)  return true;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0;i<n;i++) adj.add(new ArrayList<>());

        // created adj list for undirected graph
        for (int i=0;i<edges.length;i++){
            int u= edges[i][0];
            int v= edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int [] parent= new int[n];
        int []vis=new int[n];
        for (int i=0;i<n;i++){
            parent[i]=-1;
            vis[i]=0;
        }

        //we will start will BFS to check cycles
        Queue<Integer> q= new LinkedList<>();
        int count=0;
        for (int i=0;i<n;i++){
            if (vis[i]==0){
                count++;
                if (count>1)  return false;
                q.add(i);
                vis[i]=1;

                while(!q.isEmpty()){
                    int u= q.poll();
                    for (int v: adj.get(u)){

                        if (vis[v]==0){
                            vis[v]=1;
                            parent[v]=u;
                            q.add(v);
                        }
                        else if (parent[u]!=v)  return false;
                    }
                }

            }
        }

        return true;


    }
}
