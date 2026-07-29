class Solution {
    public int appendCharacters(String s, String t) {

        int i=0,j=0;
        int n= s.length();
        int m= t.length();

        while(i<n && j<m){
            if (s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }

        if (i==n && j==m)  return 0;
        if (i==n)  return m-j;

        return 0;
        
        
    }
}