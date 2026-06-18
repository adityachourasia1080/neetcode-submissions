class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // forming the adj matric 
        if (n == 1) return Arrays.asList(0);
        List<List<Integer>>lis= new ArrayList<>();
        int i=0;
        int leaf[]= new int[n];
        for (i=0;i<n;i++){
            lis.add(new ArrayList<>());
        }

        for (i=0;i<edges.length;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            lis.get(u).add(v);
            lis.get(v).add(u);
            leaf[u]++;
            leaf[v]++;
        }

        Queue<Integer>q= new LinkedList<>();
        for (i=0;i<n;i++){
            if (leaf[i]==1)  {
                q.add(i);
            }
        }

       

        // Add this before the while loop
int remaining = n;

// Change your while loop condition and add remaining tracking
while (remaining > 2) {
    int len = q.size();
    remaining -= len;        // ← subtract BEFORE processing
    while (len > 0) {
        int u = q.poll();
        for (int v : lis.get(u)) {
            leaf[v]--;
            if (leaf[v] == 1) q.offer(v);
        }
        len--;
    }
}


        List<Integer> ans= new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll());
        }

        return ans;
        
    }
}