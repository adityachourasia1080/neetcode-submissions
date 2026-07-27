class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> mp = new HashMap<>();

        for (int i=0;i<s1.length();i++){
            mp.put(s1.charAt(i),mp.getOrDefault(s1.charAt(i),0)+1);
        }

        int distict= mp.size();

        int left=0;
        int right=0;
        int k= s1.length();
        int n= s2.length();

        while(right<n){
            Character ch= s2.charAt(right);
            if (mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
                if (mp.get(ch)==0)  distict--;
            }

            if (right+1>=k){
                if (distict==0){
                    return true;
                }

                if (mp.containsKey(s2.charAt(left))){
                    mp.put(s2.charAt(left),mp.get(s2.charAt(left))+1);
                    if (mp.get(s2.charAt(left))==1)  distict++;
                }
                left++;
            }

            right++;

        }

        return false;
        
    }
}
