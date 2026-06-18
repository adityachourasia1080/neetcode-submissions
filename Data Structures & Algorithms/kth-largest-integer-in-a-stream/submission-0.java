class KthLargest {
    Queue<Integer> pq;
    int len;

    public KthLargest(int k, int[] nums) {
        pq= new PriorityQueue<>();
        this.len=k;
        for (int num: nums){
            pq.offer(num);
            if (pq.size()>len) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size()>len) pq.poll();
        return pq.peek();
        
    }
}
