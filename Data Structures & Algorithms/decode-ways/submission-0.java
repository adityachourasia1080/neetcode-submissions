class Solution {
    private int decode(String s,int[]dp,int index){
        if (index==s.length())  return 1;
        if (s.charAt(index)=='0')  return 0;
        
        if (dp[index]!=-1) return dp[index];
        int ans=0;
        //one term
        ans= decode(s,dp,index+1);

        //two term as checking
        if (index+1<s.length()){
            int first= s.charAt(index)-'1'+1;
            int second= s.charAt(index+1)-'1'+1;

            first= first*10 + second;
            if (first>=1 && first <=26){
                ans+=decode(s,dp,index+2);
            }
        }
        dp[index]=ans;
        return ans;
    }
    public int numDecodings(String s) {
        int n= s.length();
        int dp[]= new int[n];
        for (int i=0;i<n;i++) dp[i]=-1;

        return decode(s,dp,0);
        
    }
}
