class Solution {
    class pair{
        int freq;
        Character ch;

        public pair(int freq,Character ch){
            this.freq= freq;
            this.ch=ch;
        }
    }
    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<pair>pq= new PriorityQueue<>((x,y)->{
            return Integer.compare(y.freq,x.freq);
        });

        if (a!=0) pq.offer(new pair(a,'a'));
        if (b!=0)  pq.offer(new pair(b,'b'));
        if (c!=0)  pq.offer(new pair(c,'c'));
        

        StringBuilder str= new StringBuilder();

        if (!pq.isEmpty()){
            pair temp= pq.poll();
            str.append(temp.ch);
            temp.freq--;
            if (temp.freq>=1){
                str.append(temp.ch);
                temp.freq--;
               
            }
            if (temp.freq!=0) pq.offer(temp);   
        }


        while(!pq.isEmpty()){
          
          Character last= str.charAt(str.length()-1);
          pair temp1= pq.poll();
          if (temp1.ch!=last){
            str.append(temp1.ch);
            temp1.freq--;
            if (temp1.freq>=1){
                str.append(temp1.ch);
                temp1.freq--;
               
            }
            if (temp1.freq!=0) pq.offer(temp1);  

          }
          else if (!pq.isEmpty()){
            pair temp2= pq.poll();
            str.append(temp2.ch);
            temp2.freq--;
            if (temp2.freq!=0) pq.offer(temp2);  
            pq.offer(temp1);

          }
          else break;
        }

        return  str.toString();

    
}
}