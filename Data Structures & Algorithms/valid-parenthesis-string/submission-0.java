class Solution {

    private boolean dfs(String s,int index,int open,Boolean dp[][]){
        if (open<0)  return false;
        if (index==s.length())
        {
            return open==0;
        }
        if (dp[index][open]!=null)   return dp[index][open];
        
        Boolean result= false;
        if (s.charAt(index)=='('){
            result= dfs(s,index+1,open+1,dp);
        }
        else if (s.charAt(index)==')'){
            result= dfs(s,index+1,open-1,dp);
        }
        else { 
            result =
                dfs(s,index + 1, open,dp) ||       // empty
                dfs(s,index + 1, open + 1,dp) ||   // '('
                dfs(s,index + 1, open - 1,dp);     // ')'
        }


        return dp[index][open]=result;
    }

    public boolean checkValidString(String s) {

        int n= s.length();
        Boolean dp[][]= new Boolean[n][n];
        return dfs(s,0,0,dp);
        
    }
}