class Solution {

    private void form(String s, int start,StringBuilder str,HashSet<String> st, List<String> ans ){
       if (start>= s.length()){
            ans.add( str.toString());
            return ;
       }

       for (int i=start;i<s.length();i++){

           if (!st.contains(s.substring(start,i+1))) continue;
            StringBuilder temp= new StringBuilder();
            temp.append(str);
            if (str.length()!=0)   temp.append(' ');
            temp.append(s.substring(start,i+1));
            form(s,i+1,temp,st,ans);

       }


    }

    public List<String> wordBreak(String s, List<String> wordDict) {


        StringBuilder str= new StringBuilder();
        HashSet<String> st= new HashSet<>();
        for (String temp : wordDict) st.add(temp);
        List<String> ans= new ArrayList<>();
         form(s,0,str,st,ans);
         return ans;
        
    }
}