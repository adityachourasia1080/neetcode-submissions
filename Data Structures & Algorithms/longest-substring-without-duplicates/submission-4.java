class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxSeenIndex=-1;
        HashMap<Character,Integer> last= new HashMap<>();

        int ans=0;


        for (int i=0;i<s.length();i++){
            
            Character ch= s.charAt(i);
            if (!last.containsKey(ch)) last.put(ch,-1);
            maxSeenIndex= Math.max(maxSeenIndex, last.get(ch));
            ans= Math.max(ans, i-maxSeenIndex);
            last.put(ch,i);
        }

        return ans;
        
        
    }
}
