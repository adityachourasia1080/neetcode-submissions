class Solution {
    public int characterReplacement(String s, int k) {
        int n= s.length();
        int freq[] = new int[26];
        for (int i=0;i<26;i++)  freq[i]=0;

        int ans=k;
        int i=0,j=0;
         int mostfreq=0;
        while(j<n){
            int idx= s.charAt(j)-'A';
          freq[idx]++;
          mostfreq=Math.max(mostfreq,freq[idx]);
          
          if (j+1-i-mostfreq<=k){
            ans=Math.max(ans,j+1-i);
          }else{
            while(j+1-i-mostfreq>k){
                freq[s.charAt(i)-'A']--;
                    int temp = Integer.MIN_VALUE;
                    for (int h = 0; h < 26; h++) {
                        temp = Math.max(temp, freq[h]);
                    }
                    mostfreq = temp;

                    i++;
            }
          }

          j++;
        }

        return ans;
    
        
    }
}
