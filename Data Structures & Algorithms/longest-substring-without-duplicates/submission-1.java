class Solution {
    public int lengthOfLongestSubstring(String s) {

        int i=0;
        int ans=0;
        HashSet<Character> st= new HashSet<>();
        for (int j=0;j<s.length();j++){
            Character c=s.charAt(j);
             if (!st.contains(c)){
                ans=Math.max(ans,j+1-i);
                st.add(c);
             }
             else{
                while(s.charAt(i)!=c){
                    st.remove(s.charAt(i));
                    i++;
                }
                i++;
             }
        }

        return ans;
        
    }
}
