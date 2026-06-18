class Solution {
    class pair{
        public int num1;
        public int num2;
        public pair(int num1,int num2)
            {
                this.num1=num1;
                this.num2=num2;
            }    
        }

        private ArrayList<pair> merge(List<pair>lis){
            ArrayList<pair> res= new ArrayList<>();
            int start=lis.get(0).num1;
            int end= lis.get(0).num2;
            for (int j=1;j<lis.size();j++){
                if (lis.get(j).num1<=end){
                    end= Math.max(end,lis.get(j).num2);
                }
                else{
                    res.add(new pair(start,end));
                    start=lis.get(j).num1;
                    end= lis.get(j).num2;
                }
            }
            res.add(new pair(start,end));
            return res;
        }

    public int[][] insert(int[][] it, int[] ni) {

        int n= it.length;
        if (n==0) return new int[][]{{ni[0],ni[1]}};
        int m= ni.length;
        List<pair>lis = new ArrayList<>();
       
        for (int i=0;i<n;i++){
            lis.add(new pair(it[i][0],it[i][1]));
        }

        lis.add(new pair(ni[0],ni[1]));
        int i=n-1;
          while(i>=0 && it[i][0]>ni[0]){
            lis.set(i+1,lis.get(i));
            i--;
          }

          lis.set(i+1,new pair(ni[0],ni[1]));
         
          ArrayList<pair> res= merge(lis);
         

          int [][]ans= new int[res.size()][2];
          for (int j=0;j<res.size();j++){
            ans[j][0]= res.get(j).num1;
            ans[j][1]= res.get(j).num2;
          }

          return ans;
        
    }
}
