class Solution {
    public boolean checkInclusion(String s1, String s2) {

        //edge case
        int len2= s2.length();
        int len1= s1.length();
        if (len1>len2)  return false;

        //freq
        HashMap<Character,Integer> freq= new HashMap<>();
        for (int i=0;i<len1;i++){
            freq.put(s1.charAt(i),freq.getOrDefault(s1.charAt(i),0)+1);
        }

        //disticnt character in s1
        int distinct = freq.size();
        int i=0,j=0;
        

        //fixed size sliding window 
        while(j<len2){
            Character c= s2.charAt(j);
            if (freq.containsKey(c)){
                freq.put(c,freq.get(c)-1);
                if (freq.get(c)==0) distinct--;
            }

            if (j-i+1==len1){
                if (distinct==0){
                    return true;
                }
                Character c1= s2.charAt(i);
                if (freq.containsKey(c1)){
                    freq.put(c1,freq.get(c1)+1);
                    if (freq.get(c1)==1) distinct++;
                }
                i++;
            }
            j++;

        }
        return false;
        
    
        
    }
}