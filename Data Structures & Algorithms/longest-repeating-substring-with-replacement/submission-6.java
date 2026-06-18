class Solution {
    private int findmax(int freq[]){
        int max=0;
        for (int i=0;i<26;i++){
            if (freq[i]>max) max= freq[i];
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
        if (s==null || s.length()==0 )  return 0;
        int freq[]= new int[26];
        int i=0,j=0;
        int n= s.length();
        int ans=0;
        while(j<n){
            int pos= s.charAt(j)-'A';
            freq[pos]++;
            int len= j+1-i;
            int maxfreq= findmax(freq);
            while (len-maxfreq>k){
                freq[s.charAt(i)-'A']--;
                i++;
                len--;
                maxfreq=findmax(freq);
            }

            ans= Math.max(ans,j+1-i);
            j++;

        }

        return ans;
        
    }
}
