class Solution {
    public String longestPalindrome(String s) {

        //t.c : O(n^3)  brute force  // O(1)
       if (s==null || s.length()==0)  return s;
        int lon=1;
        String ans=s.substring(0,1);
        int i=1;
        int left=0,right=0;
        int n= s.length();
        for (i=1;i<s.length();i++){

            // odd length;
            left=i-1;
            right=i+1;

            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                int len= right+1-left;
                if (len>lon){
                    lon=len;
                    ans=s.substring(left,right+1);
                }
                left--;
                right++;
            }

            // even length
            left=i-1;
             right=i;
              while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                int len= right+1-left;
                if (len>lon){
                    lon=len;
                    ans=s.substring(left,right+1);
                }
                left--;
                right++;
            }

           
        }

        return ans;
        
    }
}
