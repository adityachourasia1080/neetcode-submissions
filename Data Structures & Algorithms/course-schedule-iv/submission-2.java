class Solution {
    public List<Boolean> checkIfPrerequisite(int  c, int[][] p, int[][] qu) {


        List<List<Integer>> adj = new ArrayList<>();

        int ind[]= new int[c];
        int counter=0;

        for (int i=0;i<c;i++) adj.add(new ArrayList<>());

        boolean connect[][]= new boolean[c][c];
        

        for (int i=0;i<p.length;i++){
            int u= p[i][0];
            int v= p[i][1];
            adj.get(u).add(v);
            ind[v]++;
            connect[u][v]=true;
        }

        Deque<Integer> q= new ArrayDeque<>();
        for (int i=0;i<c;i++){
            if (ind[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int u= q.poll();
            for (int v: adj.get(u)){

                for (int i=0;i<c;i++){
                    if (connect[i][u]){
                        connect[i][v]=true;
                    }
                }

                ind[v]--;
                if (ind[v]==0) q.add(v);

            }

        }

        List<Boolean> ans= new ArrayList<>();

        for (int i=0;i<qu.length;i++){

            int u= qu[i][0];
            int v= qu[i][1];

            if (connect[u][v]==true){
                ans.add(true);
            }
            else ans.add(false);
        }

        return ans;
        
    }
}