class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> mp= new HashMap<>();
        for (int i=0;i<t.length();i++){
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0)+1);
        }

        int distinct = mp.size();
        int n= s.length();

        int i=0,j=0;

        String res="";

        while(j<n){
            if (mp.containsKey(s.charAt(j))){
                mp.put(s.charAt(j),mp.get(s.charAt(j))-1);

                if (mp.get(s.charAt(j))==0) distinct--;

                while(distinct==0){
                   String temp= s.substring(i,j+1);
                   if (res==""  || res.length()> temp.length())  res= temp;
                
                   Character ch=s.charAt(i);
                   if (mp.containsKey(ch)){
                      mp.put(ch, mp.get(ch)+1);
                      if (mp.get(ch)==1) distinct++;
                   }
                    i++;
                }  
            }
            j++;
        }

        return res;
        
    }
}
