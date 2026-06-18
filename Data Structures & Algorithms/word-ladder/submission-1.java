class Solution {
    public int ladderLength(String beginWord, String end, List<String> w) {
        HashSet<String> st =new HashSet<>();
        boolean ispresent= false;
    
        for (int i=0;i<w.size();i++){
            st.add(w.get(i));
            if (w.get(i).equals(end))  ispresent=true;
        }

        if (ispresent==false)  return 0;

        Queue<StringBuilder> q= new LinkedList<>();
        q.add(new StringBuilder(beginWord));
        int count=0;
        while(!q.isEmpty()){
            int len= q.size();
            count++;
            while(len>0){
            StringBuilder temp= q.poll();
            for (int i=0;i<temp.length();i++){
                char ch= temp.charAt(i);
                for (char c='a';c<='z';c++){
                    temp.setCharAt(i,c);
                    String str= temp.toString();
                    if (st.contains(str)){
                        if (str.equals(end))  return count+1;
                        q.add(new StringBuilder(str));
                        st.remove(str);
                    }
                }

                temp.setCharAt(i,ch);
             }
             
             len--;
            }
        }

        return 0;

        
    }
}
