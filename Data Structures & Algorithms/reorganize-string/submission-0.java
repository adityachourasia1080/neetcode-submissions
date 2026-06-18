class Solution {
    class pair{
        public Character c;
        public int freq;

        public pair(Character c,int freq){
            this.c=c;
            this.freq= freq;
        }
    }

    public String reorganizeString(String s) {
        HashMap<Character,Integer>mp= new HashMap<>();

        for (int i=0;i<s.length();i++){
            Character c= s.charAt(i);
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        PriorityQueue<pair>pq= new PriorityQueue<>((a,b)->{
            return Integer.compare(b.freq,a.freq);
        });

        for (Map.Entry<Character,Integer> e: mp.entrySet()){
            pq.offer(new pair(e.getKey(),e.getValue()));
        }



        StringBuilder str= new StringBuilder();

        pair temp= pq.poll();
        str.append(temp.c);
        temp.freq--;
        if(temp.freq>0) pq.offer(temp);

        while(!pq.isEmpty()){

                Character last= str.charAt(str.length()-1);
                pair first= pq.poll();
                 if (last!=first.c){
                    str.append(first.c);
                    first.freq--;
                    if (first.freq>0) pq.offer(first);
                 }else{
                    if (!pq.isEmpty()){
                       pair second= pq.poll();
                       str.append(second.c);
                       second.freq--;
                       pq.offer(first);
                       if (second.freq>0) pq.offer(second);
                    }
                    else  return "";
                 }
           
        }

        return str.toString();
        
    }
}