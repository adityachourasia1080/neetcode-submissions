class Solution {
    HashSet<String>lookup;
    private int solve(String s,int index,int dp[]){
        if (index==s.length())  return 0;
        if (dp[index]!=-1)  return dp[index];

        StringBuilder str= new StringBuilder();
        int ans= Integer.MAX_VALUE;

        for (int i=index;i<s.length();i++){
            str.append(s.charAt(i));
            int a=0;
            int b=0;
            if (!lookup.contains(str.toString())) a=str.length();
            b= solve(s,i+1,dp);
            ans=Math.min(ans,a+b);
        }

        return dp[index]=ans;
    }
    public int minExtraChar(String s, String[] dictionary) {

        lookup= new HashSet<>();
        for (String st: dictionary) lookup.add(st);

        int dp[]= new int [s.length()];
        for (int i=0;i<s.length();i++)  dp[i]=-1;

        return solve(s,0,dp);
        
    }
}