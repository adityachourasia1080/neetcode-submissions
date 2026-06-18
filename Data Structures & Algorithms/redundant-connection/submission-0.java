class Solution {

    void union(int u,int v,int parentu,int parentv,int parent[],int count[]){
        if (count[parentu]>count[parentv]){
            count[parentu]+=count[parentv];
            parent[parentv]=parentu;
        }
        else{
            count[parentv]+=count[parentu];
            parent[parentu]=parentv;
        }
    }

    int find(int u,int parent[]){
        if (parent[u]==u)  return u;
        return parent[u]=find(parent[u],parent);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        int parent[]= new int[n+1];
        int count[]= new int[n+1];
        for (int i=0;i<=n;i++) {
            parent[i]=i;
            count[i]=i;
        }
        int ansu=-1;
        int ansv=-1;
       

        for (int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v= edges[i][1];

            int ul_pu= find(u,parent);
            int ul_pv= find(v,parent);
            if (ul_pu==ul_pv){
                ansu=u;
                ansv=v;
                continue;
            }
            
            union(u,v,ul_pu,ul_pv,parent,count);
        
        }

        int []ans= new int[2];
        if (ansu!=-1 && ansv!=-1){
            ans[0]=ansu;
            ans[1]=ansv;
        }
        return ans;
        
        
    }
}