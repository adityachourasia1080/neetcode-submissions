class Solution {

    private int editDistance(String word1,String word2,int n,int m){
         if (n==0 && m==0)   return 0;
         if (n==0)  return m;
         if (m==0)   return n;

         if (word1.charAt(n-1)== word2.charAt(m-1)){
            return editDistance(word1,word2,n-1,m-1);
         }

         return 1+Math.min(editDistance(word1,word2,n-1,m),
                  Math.min(editDistance(word1,word2,n,m-1),editDistance(word1,word2,n-1,m-1)));
    }

    public int minDistance(String word1, String word2) {

        int n= word1.length();
        int m = word2.length();

        return editDistance(word1,word2,n,m);
        
    }
}
