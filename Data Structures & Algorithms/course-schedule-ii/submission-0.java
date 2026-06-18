class Solution {
    public int[] findOrder(int c, int[][] p) {

        int []ind= new int[c];
        int ans[]= new int[c];
        int count=0;
        
        List<List<Integer>>adj= new ArrayList<>();
        for (int i=0;i<c;i++){
            adj.add(new ArrayList<>());
        }

        for (int i=0;i<p.length;i++){
            int u= p[i][1];
            int v= p[i][0];
            adj.get(u).add(v);
            ind[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<c;i++){
            if (ind[i]==0)  q.add(i);
        }

        while(!q.isEmpty()){
            int u= q.poll();
            ans[count++]=u;

            for (int v: adj.get(u)){
                ind[v]--;
                if (ind[v]==0) q.add(v);
            }

        }
        

        if (count!=c)   return new int[0];
        return ans;

        
    }
}
