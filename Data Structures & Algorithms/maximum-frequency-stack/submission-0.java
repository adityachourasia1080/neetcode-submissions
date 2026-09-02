class FreqStack {
    HashMap<Integer,Integer> count ;
    TreeMap<Integer,Deque<Integer>>mp;

    public FreqStack() {
        count= new HashMap<>();
        mp= new TreeMap<>();
    }
    
    public void push(int val) {
        if (count.containsKey(val)){
            int currCount= count.get(val);
            mp.putIfAbsent(currCount+1,new ArrayDeque<>());
            mp.get(currCount+1).offerLast(val);
            count.put(val,currCount+1);
        }
        else{
            count.put(val,1);
             mp.putIfAbsent(1,new ArrayDeque<>());
             mp.get(1).add(val);
        }
    }
    
    public int pop() {
      int lastKey= mp.lastKey();
      int value= mp.get(lastKey).pollLast();
      if (mp.get(lastKey).size()==0)  mp.remove(lastKey);

      int fre= count.get(value);
      fre--;
      if (fre==0)  count.remove(value);
      else count.put(value, fre);

      return value;
      
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */