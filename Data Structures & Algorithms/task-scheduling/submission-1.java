class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> mp = new HashMap<>();
        for (int i=0;i<tasks.length;i++){
            mp.put(tasks[i],mp.getOrDefault(tasks[i],0)+1);
        }

        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for (Map.Entry<Character,Integer> e: mp.entrySet()){
            pq.offer(e.getValue());
        }

        int time=0;
        while(!pq.isEmpty()){
            List<Integer> vec= new ArrayList<>();
            int cycle= n+1;
            while(cycle>0 && !pq.isEmpty()){
                int temp= pq.poll();
                temp--;
                if(temp>0) vec.add(temp);
                cycle--;
                 time++;
            }

            for (Integer c: vec){
                pq.add(c);
            }
            if (pq.isEmpty())  break;
            time+=cycle;
        }

        return time;
        
    }
}