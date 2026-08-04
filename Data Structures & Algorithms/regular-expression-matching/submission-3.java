class Solution {
    private boolean dfs(String s,String p, int i,int j){
        if(i==s.length() && j==p.length())  return true;

        if (i==s.length()){
            if (j+1==p.length()-1 && p.charAt(j+1)=='*')  return true;
            return false;
        }
        if (j==p.length())  return false;

        char chs= s.charAt(i);
        char chp= p.charAt(j);

        if (chs==chp || chp=='.'){
            if (((j+1<p.length() &&  p.charAt(j+1)!='*') || (j+1==p.length())) && dfs(s,p,i+1,j+1))  return true;

            if (j+1<p.length() && p.charAt(j+1)=='*'){
                if (dfs(s,p,i+1,j))  return true;
            }
        }

        if (j+1<p.length() && p.charAt(j+1)=='*'){
            // skip it 
            if (dfs(s,p,i,j+2))  return true;
        }

        return false;
    }
    public boolean isMatch(String s, String p) {

        return dfs(s,p,0,0);
        
    }
}
