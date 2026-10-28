class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character,Integer> mp= new HashMap<>();
        int n= s.length();
        int m= t.length();

        if (m>n)  return "";


        String str= "";
        int ans=Integer.MAX_VALUE;
        
        for (int i=0;i<m;i++){
            mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i),0)+1);
        }

        int distinct = mp.size();

        int i=0;

        for (int j=0;j<n;j++){
            Character ch= s.charAt(j);
            if (mp.containsKey(ch)){
                int freq= mp.get(ch);
                freq--;
                if (freq==0) distinct--;

                mp.put(ch,freq);

                while(distinct==0){
                    if (ans> j+1-i){
                        ans= j+1-i;
                        str= s.substring(i,j+1);
                    }
                    ch=s.charAt(i);
                    if (mp.containsKey(ch)){
                        freq= mp.get(ch);
                        freq++;
                        if (freq==1) distinct++;
                        mp.put(ch,freq);
                    }
                    i++;
                }
            }
        }

        return str;
        
    }
}
