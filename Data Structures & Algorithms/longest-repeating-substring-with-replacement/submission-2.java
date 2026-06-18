class Solution {
    public int characterReplacement(String s, int k) {
        int n= s.length();

        int freq[] = new int[26];
        for (int i=0;i<26;i++)  freq[i]=0;

      
        int ans=k;
        // int prev=1;
        // for (int i=1;i<n;i++){
        //     if (s.charAt(i)==s.charAt(i-1)){
        //         prev+=1;
        //         ans=Math.max(prev,ans);
        //     }
        //     else prev=1;
        // }

        // if (k==0)  return ans;
          int i=0,j=0;

        while(j<n){
          freq[s.charAt(j)-'A']++;
          int mostfreq=0;
          for (int h=0;h<26;h++){
            mostfreq=Math.max(mostfreq,freq[h]);
          }

          if (j+1-i-mostfreq<=k){
            ans=Math.max(ans,j+1-i);
          }else{
            while(j+1-i-mostfreq>k){
                freq[s.charAt(i)-'A']--;
                    for (int h=0;h<26;h++){
                        mostfreq=Math.max(mostfreq,freq[h]);
                    }
                    i++;
            }
          }

          j++;
        }

        return ans;
    
        
    }
}
