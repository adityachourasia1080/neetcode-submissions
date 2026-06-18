class Solution {
    public List<Boolean> checkIfPrerequisite(int numc, int[][] p, int[][] qt) {

        HashMap<Integer,List<Integer>> mp= new HashMap<>();
        int ind[] = new int[numc];
        for (int i=0;i<p.length;i++){
            int u= p[i][0];
            int v= p[i][1];
            if (!mp.containsKey(u)) mp.put(u,new ArrayList<>());
            mp.get(u).add(v);
            ind[v]++;
        }

        Queue<Integer>q= new LinkedList<>();
        for (int i=0;i<numc;i++){
            if (ind[i]==0) q.offer(i);
        }

        int [][]arr= new int[numc][numc];

        while(!q.isEmpty()){
            int u= q.poll();
            List<Integer> lis= mp.get(u);
            if (lis!=null){
            for (int v: lis){
                ind[v]--;
                arr[u][v]=1;
                for (int i=0;i<numc;i++){
                    if (arr[i][u]==1) arr[i][v]=1;
                }
                if (ind[v]==0) q.offer(v);
            }
            }
        }

        List<Boolean> ans= new ArrayList<>();

        for (int j=0;j<qt.length;j++){
           if (arr[qt[j][0]][qt[j][1]]==1) ans.add(true);
           else ans.add(false);
        }

        return ans;
        
    }
}