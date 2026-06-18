class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int n= mat.length;
        int m= mat[0].length;

        List<Integer>ans= new ArrayList<Integer>();

        int tr=0,tc=0,br=n-1,bc=m-1;
        while(tr<=br && tc<=bc){

            
                for (int i=tc;i<=bc;i++) ans.add(mat[tr][i]);
                tr++;
           
            
                for (int i=tr;i<=br;i++) ans.add(mat[i][bc]);
                bc--;
            

            if (tr<=br){
                for (int i=bc;i>=tc;i--) ans.add(mat[br][i]);
                br--;
            }

            if (tc<=bc ){
                for (int i=br;i>=tr;i--) ans.add(mat[i][tc]);
                tc++;
            }
        }

        return ans;
        
    }
}
