class Solution {
    public int lengthOfLongestSubstring(String s) {

        int i=0;
        int ans=0;
        HashSet<Character> seen= new HashSet<>();
        
        for (int j=0;j<s.length();j++){
           if (seen.contains(s.charAt(j))){
            while(s.charAt(i)!=s.charAt(j)){
                seen.remove(s.charAt(i));
                i++;
            }
            i++;
           }
           else{
            seen.add(s.charAt(j));
           }

           ans= Math.max(ans,j-i+1);

        }

        return ans;
        
    }
}
