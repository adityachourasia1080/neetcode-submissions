class Solution {
    private HashMap<Character,String> createMap(){
        HashMap<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        return phoneMap;

    }
    public List<String> letterCombinations(String digits) {

        HashMap<Character,String> mp= createMap();
        Queue<String> q= new LinkedList<>();
         List<String> ans= new ArrayList<>();

         if (digits.length()==0)  return ans;
        q.offer("");

        for (int i=0;i<digits.length();i++){
            int len= q.size();
            String temp= mp.get(digits.charAt(i));

            for (int j=0;j<len;j++){
                String str= q.poll();

                for (int k=0;k<temp.length();k++){
                    StringBuilder st= new StringBuilder(str);
                    st.append(temp.charAt(k));
                    q.offer(st.toString());

                }

            }
        }

       
        while(!q.isEmpty()) ans.add(q.poll());
        return ans;

        
    }
}