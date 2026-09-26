class Solution {
    public int ladderLength(String b, String e, List<String> w) {

        if (b.equals(e))  return 0;

        Set<String> st= new HashSet<>();
        for (String str: w)  st.add(str);

        if (!st.contains(e))  return 0;

        Queue<StringBuilder> q= new LinkedList<>();
        q.offer(new StringBuilder(b));

        int transform=0;
        if (st.contains(b)) st.remove(b);

        while(!q.isEmpty()){
            int len= q.size();
             transform++;
            while(len>0){
                StringBuilder str= q.poll();
                for (int i=0;i<str.length();i++){
                    for (char c='a';c<='z';c++){
                        char ori= str.charAt(i);
                        str.setCharAt(i,c);
                        String temp= str.toString();
                        if (temp.equals(e))   return transform+1;
                        if (st.contains(temp)){
                            q.offer(new StringBuilder(temp));
                            st.remove(temp);
                        }
                        str.setCharAt(i,ori);
                    }
                }


                len--;
            }
        }


        return 0;
        
    }
}
