class Solution {
    // idea:
//     DP Idea

// At any index i, what really matters is:

// How many open brackets ( are currently unmatched?

// So define:

// State
// dp[i][open] = true/false


// i → current index in string

// open → number of unmatched '(' till index i

// dp[i][open] → is it possible to reach here?

// 🎯 Goal

// At the end:

// dp[n][0] == true


// (no unmatched open brackets)

// 🔁 Transitions

// Let c = s.charAt(i)

// Case 1: '('
// dp[i+1][open+1] = true

// Case 2: ')'

// Only if open > 0:

// dp[i+1][open-1] = true

// Case 3: '*'

// Three choices:

// 1. treat as '('  → dp[i+1][open+1]
// 2. treat as ')'  → dp[i+1][open-1] (if open > 0)
// 3. treat as ''   → dp[i+1][open]

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