class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        //IDEA

        HashMap<String,List<String>>adj= new HashMap<>();
        for (int i=0;i<tickets.size();i++){
            String u= tickets.get(i).get(0);
            String v= tickets.get(i).get(1);
            adj.putIfAbsent(u,new ArrayList<>());
            adj.get(u).add(v);

        }


        for (Map.Entry<String,List<String>> e: adj.entrySet()){
            String key= e.getKey();
            List<String> val= e.getValue();

            Collections.sort(val, (a, b) -> b.compareTo(a));
            adj.put(key, val);
        }


        String start= "JFK";

        Deque<String> dq= new ArrayDeque<>();
        Deque<String> st= new ArrayDeque<>();

        st.offerLast(start);

        while(!st.isEmpty()){

            String temp= st.peekLast();
            if (adj.containsKey(temp)){
                List<String> lis= adj.get(temp);
                st.offerLast(lis.get(lis.size()-1));
                lis.remove(lis.size()-1);
                if (lis.size()==0) adj.remove(temp);
                else adj.put(temp,lis); 
            }
            else{
                dq.offerFirst(st.pollLast());
            }
        }


        List<String> res= new ArrayList<>();
        while(!dq.isEmpty()){
            res.add(dq.pollFirst());
        }

        return res;
        
    }
}
