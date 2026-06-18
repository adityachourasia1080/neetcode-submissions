class Solution {
    private boolean find(String s,String p,int i,int j,int [][]mem){
        if (j==p.length()){
            return i == s.length();
        }
        if (mem[i][j]!=-1){
            if (mem[i][j]==1)  return true;
            return false;
        }

        boolean first= (i<s.length()&& ( s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));

        if (j+1<p.length() && p.charAt(j+1)=='*'){
            first= find(s,p,i,j+2,mem) || (first && find(s,p,i+1,j,mem));
        }
        else{
            first= first && find(s,p,i+1,j+1,mem);
        }

        if(first==true) mem[i][j]=1;
        else mem[i][j]=0;

        return first;
    }
    public boolean isMatch(String s, String p) {
         int n= s.length()+1;
         int m= p.length()+1;
         int mem[][]=new int[n][m];

         for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                mem[i][j]=-1;
            }
         }

        return find(s,p,0,0,mem);
        
    }
}