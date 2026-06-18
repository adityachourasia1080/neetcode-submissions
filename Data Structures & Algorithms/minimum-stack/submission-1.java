class MinStack {
    ArrayDeque<Long> st;
    long min;

    public MinStack() {
        st= new ArrayDeque<>();
    }
    
    public void push(int val) {
        long val1= (long)val;
        if (st.isEmpty()){
            min= val1;
            st.offerLast(val1);
            return;
        }
        if (val1>=min){
            st.offerLast(val1);
        }
        else{
            long temp= (2*val1)-min;
            st.offerLast(temp);
            min=val1;
        }
        
    }
    
    public void pop() {
        if (st.peekLast()>=min) st.pollLast();
        else min= (2*min)-st.pollLast();
        
    }
    
    public int top() {
        if (st.peekLast()>=min) return (int)(long)st.peekLast();
        return (int)(long)min;
        
    }
    
    public int getMin() {
        return (int)(long)min;
        
    }
}
