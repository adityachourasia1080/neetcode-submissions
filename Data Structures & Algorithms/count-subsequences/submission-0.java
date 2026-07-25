class Solution {
    private int find(String s, String t, int x,int y,Integer memo[][]){
        if (y==t.length())  return 1;
        if (x==s.length())  return 0;

        if (memo[x][y]!=null)   return memo[x][y];

        // two option match or skip
        int option=0;
        if (s.charAt(x)==t.charAt(y)){
             option= find(s,t,x+1,y+1,memo);
        }

        option+= find(s,t,x+1,y,memo);

        memo[x][y]=option;
        return option;
    }

    public int numDistinct(String s, String t) {

        Integer memo[][]= new Integer[s.length()+1][t.length()+1];
        return find(s,t,0,0,memo);
        
    }
}
