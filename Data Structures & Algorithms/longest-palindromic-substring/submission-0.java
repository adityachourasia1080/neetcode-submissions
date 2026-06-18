class Solution {
    public String longestPalindrome(String s) {
        
        //Dynamic Programming 1
        int n= s.length();
        int dp[][]= new int[n][n];
        if (n==1)  return s;
        
        String ans=null;

        for (int k=0;k<n;k++){
            int j=k;
            for (int i=0;i<n-k;i++){
                if (k==0){
                    dp[i][j]=1;
                    ans= s.substring(i,j+1);
                }
                else if (k==1){
                    if (s.charAt(i)==s.charAt(j)){
                        ans= s.substring(i,j+1);
                        dp[i][j]=1;
                    }
                    else dp[i][j]=0;
                }
                else{

                if (dp[i+1][j-1]==1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=1;
                    ans= s.substring(i,j+1);
                }
                else dp[i][j]=0;
                }
                j++;
            }
        }

        return ans;
        
    }
}
