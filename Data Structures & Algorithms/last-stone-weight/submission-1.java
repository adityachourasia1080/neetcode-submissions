class Solution {
    public int lastStoneWeight(int[] stones) {

            PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->Integer.compare(b,a));
            for (int c: stones){
                pq.offer(c);
            }


            while(pq.size()>1){
                int a= pq.poll();
                int b= pq.poll();
                if (a!=b){
                    pq.offer(Math.abs(a-b));
                }
            }

            return pq.isEmpty() ? 0: pq.poll();
        
    }
}
