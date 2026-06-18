class Solution {
    public String decodeString(String st) {
        int n= st.length();
        StringBuilder temp= new StringBuilder();
        ArrayDeque<String>dq= new ArrayDeque<>();
        int i=0;

        while(i<n){
            if (st.charAt(i)>='0' && st.charAt(i)<='9'){
                if (!temp.isEmpty()) dq.offerLast(new String(temp.toString()));
                temp.setLength(0);
                int index= st.indexOf('[',i);
                dq.offerLast(new String(st.substring(i,index)));
                i=index;
            }
            else if (st.charAt(i)==']'){
                if (!temp.isEmpty()) dq.offerLast(new String(temp.toString()));
                temp.setLength(0);
                StringBuilder str= new StringBuilder();
                while( !(dq.peekLast().charAt(0)>='0' && dq.peekLast().charAt(0)<='9')) str.insert(0,dq.pollLast());
                

                Integer r= Integer.parseInt(dq.pollLast());
                StringBuilder ans= new StringBuilder();
                for (int j=0;j<r;j++) ans.append(str);
                dq.offerLast(new String(ans.toString())); 
            }
            else temp.append(st.charAt(i));

            i++;
            
        }

        if (!temp.isEmpty())  dq.offerLast(temp.toString());

        StringBuilder res= new StringBuilder();

        while(!dq.isEmpty()) res.append(dq.pollFirst());

        return res.toString();
        

        
    }
}