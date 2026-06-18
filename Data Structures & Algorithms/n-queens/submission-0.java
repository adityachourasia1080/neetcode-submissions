class Solution {
    List<List<String>> res;

    private boolean isSafe(int r,int c,List<StringBuilder> str,int n){
        // top-bottom check
        for (int i=0;i<r;i++){
            if (str.get(i).charAt(c)=='Q')  return false;
        }

        //left-right check
        for (int i=0;i<c;i++){
            if (str.get(r).charAt(i)=='Q')   return false;
        }

        // topleft-bottom diagonal check
        int i=r-1,j=c-1;

        while(i>=0 && j>=0){
            if (str.get(i).charAt(j)=='Q')  return false;
            i--;
            j--;
        }

        //top-right  bottom left diagonal check
        i=r-1;
        j=c+1;
        while(i>=0 && j<n){
            if (str.get(i).charAt(j)=='Q')  return false;
            i--;
            j++;
        }

        return true;
    }

    private void backtrack(int n,int r,List<StringBuilder> str){
        if (r==n){
            List<String> temp= new ArrayList<>();
            for (int i=0;i<n;i++){
                temp.add(str.get(i).toString());
            }
            res.add(temp);
            return;
        }

        for (int i=0;i<n;i++){
            if (isSafe(r,i,str,n)){
                str.get(r).setCharAt(i,'Q');
                backtrack(n,r+1,str);
                str.get(r).setCharAt(i,'.');
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        res= new ArrayList<>();
        List<StringBuilder> lis= new ArrayList<>();

        StringBuilder str= new StringBuilder();
        for (int i=0;i<n;i++) str.append('.');

        for (int i=0;i<n;i++){
            lis.add(new StringBuilder(str));
        }

        backtrack(n,0,lis);
        return res;
        

        
        
    }
}
