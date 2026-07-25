class Solution {

    private List<String> form(String s, int start,HashSet<String> st, Map<Integer,List<String>>memo ){

      List<String> ans= new ArrayList<>();
       if (start>= s.length()){
            ans.add("");
            return ans;
       }
       if (memo.containsKey(start))   return memo.get(start);

       for (int i=start;i<s.length();i++){
           String temp= s.substring(start,i+1);
           if (!st.contains(temp)) continue;

           List<String> subseq= form(s,i+1,st,memo);
            
           for (String sub : subseq){
              String tmr= (sub.length()==0)?  temp : temp + " " + sub;
              ans.add(tmr);
           }
       }

       memo.put(start, ans);
       return ans;

    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> st= new HashSet<>(wordDict);
        Map<Integer, List<String>>memo= new HashMap<>();
        return form(s,0,st,memo);
        
    }
}