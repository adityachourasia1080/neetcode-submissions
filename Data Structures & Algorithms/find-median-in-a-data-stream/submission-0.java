class MedianFinder {
    PriorityQueue<Integer> minh;
    PriorityQueue<Integer>maxh;
    public MedianFinder() {
        minh= new PriorityQueue<>();
        maxh= new PriorityQueue<>((a,b)->Integer.compare(b,a)); 
    }
    
    public void addNum(int num) {
        if (maxh.isEmpty()) {
            maxh.offer(num);
            return;
        }

        if (maxh.size()>minh.size()){
            if (num>=maxh.peek()){
                minh.offer(num);
            }
            else{
                minh.offer(maxh.poll());
                maxh.offer(num);
            }

        }
        else{

            if (num<=maxh.peek()){
                maxh.offer(num);
            }
            else{
                minh.offer(num);
                maxh.offer(minh.poll());
            }

        }
        
    }
    
    public double findMedian() {
        if(minh.size()==maxh.size()){
            return (double)(minh.peek()+maxh.peek())/2;
        }

            return (double) maxh.peek();
        
    }
}
