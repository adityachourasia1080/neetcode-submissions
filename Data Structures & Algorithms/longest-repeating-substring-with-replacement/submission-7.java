class Solution {

    private int max(int [] freq){
        int mx=0;

        for (int i=0;i<26;i++){
            if (freq[i]>mx) mx= freq[i];
        }
        return mx;
    }
    public int characterReplacement(String s, int k) {

        int [] freq= new int[26];
        int i=0;
        int ans=0;

        for (int j=0;j<s.length();j++){
            int index= s.charAt(j)-'A';

            freq[index]++;

            while((j-i+1)-max(freq)>k){
                index= s.charAt(i)-'A';
                freq[index]--;
                i++;
            }

            ans= Math.max(ans,j-i+1);
        }

        return ans;
        
    }
}
