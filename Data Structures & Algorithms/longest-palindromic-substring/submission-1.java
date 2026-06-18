class Solution {
    public String longestPalindrome(String s) {

        // even odd index
        int n= s.length();
        if (n==1)  return s;

        String ans=null;
        ans=s.substring(0,1);
        int maxLength=1;

        for (int k=1;k<n;k++){

            //odd index;
            int i=k-1;
            int j=k+1;

            while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
                if (maxLength < (j+1-i)){
                    maxLength=j+1-i;
                    ans= s.substring(i,j+1);
                }
                i--;
                j++;
            }

            //even index;
            i=k-1;
            j=k;
            while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
                if (maxLength < (j+1-i)){
                    maxLength=j+1-i;
                    ans= s.substring(i,j+1);
                }
                i--;
                j++;

            }
        }

        return ans;

        
    }
}
