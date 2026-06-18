class Solution {
    public boolean canFinish(int n, int[][] p) {

        int ind[]=new int[n];
        List<List<Integer>>adj= new ArrayList<>();
        for (int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            ind[i]=0;
        }

        for (int i=0;i<p.length;i++){
            int u= p[i][1];
            int v= p[i][0];
            ind[v]++;
            adj.get(u).add(v);
        }

        //BFS
        Queue<Integer>q= new LinkedList<>();
        for (int i=0;i<n;i++) {
            if (ind[i]==0)  q.add(i);
        }

        while(!q.isEmpty()){
            int u= q.poll();
            for (int v: adj.get(u)){
                ind[v]--;
                if (ind[v]==0) q.add(v);
            }
        }

        for (int i=0;i<n;i++) {
            if (ind[i]!=0)   return false;
            }

            return true;
        
        
    }
}
