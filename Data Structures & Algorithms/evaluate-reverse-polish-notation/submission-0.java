class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Long> st = new ArrayDeque<>();

        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                long b = st.pop();
                long a = st.pop();

                switch (t) {
                    case "+": st.push(a + b); break;
                    case "-": st.push(a - b); break;
                    case "*": st.push(a * b); break;
                    case "/": st.push(a / b); break;
                }
            } else {
                st.push(Long.parseLong(t));
            }
        }
        return st.pop().intValue();
    }
}
