class Solution {
    private boolean isSafe(List<StringBuilder> temp,int row,int col){
        int r= row,c=col;
        while(c>=0 && r>=0){
           if (temp.get(r).charAt(c)=='Q')  return false;
           c--;
           r--;
        }

        r= row; c=col;
        while(r>=0){
            if (temp.get(r).charAt(c)=='Q')  return false;
            r--;
        }

        r=row;c=col;
        while(r>=0 && c<temp.size()){
            if (temp.get(r).charAt(c)=='Q')  return false;
            c++;
            r--;

        }

        return true;


    }
    private void solve(int row, List<StringBuilder>temp, List<List<String>>ans){
        if (row==temp.size()){
                    ans.add(temp.stream()
                       .map(StringBuilder::toString)
                       .collect(Collectors.toList()));
            return ;
        }

        for (int i=0;i<temp.size();i++){
            if (isSafe(temp,row,i)){
                temp.get(row).setCharAt(i,'Q');
                solve(row+1,temp,ans);
                temp.get(row).setCharAt(i,'.');
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans= new ArrayList<>();
        List<StringBuilder>temp= new ArrayList<>();
        StringBuilder str= new StringBuilder();

        for (int i=0;i<n;i++) str.append('.');
        
        for (int i=0;i<n;i++){
            temp.add(new StringBuilder(str));
        }

        solve(0,temp,ans);
        return ans;
        
    }
}
