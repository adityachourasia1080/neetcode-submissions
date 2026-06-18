class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> mp = new HashMap<>();
        int n= s.length();
        for (int i=0;i<t.length();i++){
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0)+1);
        }

        String ans="";
        int distinct= mp.size();
        int i=0,j=0;
        while(j<n){
            char c= s.charAt(j);
            if (mp.containsKey(c)){
                mp.put(c,mp.get(c)-1);
                if (mp.get(c)==0) distinct--;
            }
            
            while(distinct==0){
                char temp=s.charAt(i);
                if(ans.equals("") || j - i + 1 < ans.length()) ans=s.substring(i,j+1);
                    if (mp.containsKey(temp)){
                    mp.put(temp,mp.get(temp)+1);
                    if (mp.get(temp)>0) distinct++;
                    }
                i++;
            }
            j++;
        }

        return ans.toString();

        
    }
}
