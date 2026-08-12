class Solution {
    public int ladderLength(String b, String e, List<String> w) {

        if(b.equals(e))  return 0;
        HashSet<String> st= new HashSet<>();
        for (int i=0;i<w.size();i++){
             st.add(w.get(i));
        }

        if(st.contains(b))  st.remove(b);

        Queue<String> q= new LinkedList<>();
        q.add(b);

        int steps=1;

        while(!q.isEmpty()){

            int len=q.size();
            while(len>0)
            {
                    String temp= q.poll();
                    if(temp.equals(e))  return steps;
                    StringBuilder str= new StringBuilder(temp);


                for (int j=0;j<str.length();j++){
                        char ori= str.charAt(j);
                        for (int i=0;i<26;i++){
                            char ch= (char)('a'+i);
                            str.setCharAt(j,ch);
                            if(st.contains(str.toString())){

                                q.add(str.toString());
                                st.remove(str.toString());
                            }
                        }
                        str.setCharAt(j,ori);
                   }
                       len--;
            }
            steps++;
        }

        return 0;
        
    }
}
