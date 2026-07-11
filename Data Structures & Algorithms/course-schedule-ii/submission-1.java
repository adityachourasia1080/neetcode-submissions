class Solution {
    public int[] findOrder(int c, int[][] p) {

        List<List<Integer>> adj = new ArrayList<>();

        int ind[]= new int[c];
        int counter=0;

        for (int i=0;i<c;i++) adj.add(new ArrayList<>());
        
        int ans[]= new int[c];

        for (int i=0;i<p.length;i++){
            int v= p[i][0];
            int u= p[i][1];
            adj.get(u).add(v);
            ind[v]++;
        }


        Deque<Integer> q= new ArrayDeque<>();
        for (int i=0;i<c;i++){
            if (ind[i]==0) q.add(i);
        }


        while(!q.isEmpty()){
            int u= q.poll();
            ans[counter++]=u;

            for (int v: adj.get(u)){
                ind[v]--;
                if (ind[v]==0) q.add(v);
            }
        }

        for (int i=0;i<c;i++){
            if (ind[i]!=0)  return new int[0];
        }

        return ans;


        
    }
}
