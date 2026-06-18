class Solution {

    private int dfs(int u,List<List<Integer>> adj,boolean vis[]){
        vis[u]=true;
        int temp=0;
        for (int v: adj.get(u)){
            if (vis[v]==false){
                temp= Math.max(temp,dfs(v,adj,vis));
            }
        }
        vis[u]=false;
        return temp+1;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();
        for (int i=0;i<n;i++) adj.add(new ArrayList<Integer>());
        
        for (int i=0;i<edges.length;i++){
           int u= edges[i][0];
           int v= edges[i][1];
           adj.get(u).add(v);
           adj.get(v).add(u);
        }

        boolean vis[]=new boolean[n];
        HashMap<Integer,List<Integer>>mp= new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            int temp=dfs(i,adj,vis);
            if (!mp.containsKey(temp))  mp.put(temp,new ArrayList<Integer>());
            mp.get(temp).add(i);
            ans=Math.min(ans,temp);
        }

        return mp.get(ans);
        
    }
}