class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n= s1.length();
        int m= s2.length();

        if (n>m)  return false;

        HashMap<Character,Integer>mp= new HashMap<>();

        for (int i=0;i<n;i++){
            mp.put(s1.charAt(i),mp.getOrDefault(s1.charAt(i),0)+1);
        }

        int distinct= mp.size();
        int i=0;

        for (int j=0;j<m;j++){
            Character ch= s2.charAt(j);
            if (mp.containsKey(ch)){
                int freq= mp.get(ch);
                freq--;
                mp.put(ch,freq);
                if (freq==0)  distinct--;
            }

            if (j>=n-1){
                if (distinct==0)    return true;
                ch= s2.charAt(i);
                if (mp.containsKey(ch)){
                    int freq= mp.get(ch);
                    freq++;
                    mp.put(ch,freq);
                    if (freq==1)  distinct++;

                }
                i++;
            }
            
        }
        return false;
        
    }
}
