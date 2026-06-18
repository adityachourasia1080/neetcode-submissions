class Solution {

    // smallest substring having all character of t including the duplicates

    // string : Aditya   t=dy   op: dity   4
    // Aditya     t="io"   op: ""

    // Simple : O(n^3)   space Complexity : o(t)
    public String minWindow(String s, String t) {

        int n= s.length();
        int m= t.length();
        if (m>n)   return "";

        HashMap<Character,Integer> mp= new HashMap<>();
        for (int i=0;i<m;i++){
             mp.putIfAbsent(t.charAt(i),0);
             mp.put(t.charAt(i),mp.get(t.charAt(i))+1);
        }

        int distinct= mp.size();

        int i=0,j=0;
        // dynamic
        int len=Integer.MAX_VALUE;
        String ans="";

        while(j<n){
            char c= s.charAt(j);
             if (mp.containsKey(c)){
                mp.put(c,mp.get(c)-1);
                if (mp.get(c)==0) distinct--;
             }

             if (distinct==0){

                while(i<=j && distinct==0){
                   if (len > (j+1-i)){
                    len= j+1-i;
                    ans=s.substring(i,j+1);
                   }
                   c= s.charAt(i);
                   if (mp.containsKey(c)){
                        mp.put(c,mp.get(c)+1);
                        if (mp.get(c)==1) distinct++;
                    }
                    i++;

                }

             }
             j++;

        }

        return ans;
        
    }
}
