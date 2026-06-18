class Solution {
    class pair{
        public int first;
        public int second;
        public pair(int first,int second){
            this.first= first;
            this.second= second;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for (int num: nums) {
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        PriorityQueue<pair> minh= new PriorityQueue<>((pair a,pair b)-> Integer.compare(a.first,b.first));
        for (Map.Entry<Integer,Integer> e :mp.entrySet()){
            minh.offer(new pair(e.getValue(),e.getKey()));
            if (minh.size()>k) minh.poll();
        }
        int [] ans= new int[k];
        for (int i=0;i<k;i++){
            ans[i]= minh.poll().second;
        }

        return ans;
        
    }
}
