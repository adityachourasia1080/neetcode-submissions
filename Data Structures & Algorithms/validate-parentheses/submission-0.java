class Solution {
    private boolean check(ArrayDeque<Character>st,Character c){
        if (st.isEmpty())  return false;
        if (c=='}'  && st.peekLast()=='{')  return true;
        if (c==']' && st.peekLast()=='[')   return true;
        if (c==')' && st.peekLast()=='(')  return true;

        return false;
    }
    public boolean isValid(String s) {

        ArrayDeque<Character> st= new ArrayDeque<>();

        for (int i=0;i<s.length();i++){
            Character c= s.charAt(i);
            if (c=='{' || c=='[' || c=='('){
                st.offerLast(c);
            }
            else{
                if (check(st,c)){
                    st.pollLast();
                }
                else return false;
            }
        }

        if (!st.isEmpty())  return false;
        return true;
        
    }
}
