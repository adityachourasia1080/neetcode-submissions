class Solution {

    private int form(String s,HashSet<String> st, int index,int[]dp){
      if (index==s.length())  return 1;

      if (dp[index]!=-1)  return dp[index];
      int temp=0;
      StringBuilder str= new StringBuilder();
      for (int i=index;i<s.length();i++){
          str.append(s.charAt(i));
          if (st.contains(str.toString())){
            temp= form(s,st,i+1,dp);
            if (temp==1)  break;
          }
      }

      dp[index]= temp;
      return temp;
    }

    public boolean wordBreak(String s, List<String> w) {
        int n= s.length();
        HashSet<String> st= new HashSet<>();
        for (int i=0;i<w.size();i++){
            st.add(w.get(i));
        }

        int dp[]= new int[n];
        for (int i=0;i<n;i++) dp[i]=-1;
        form(s,st,0,dp);
        return dp[0]==1 ? true: false;
        
    }
}
