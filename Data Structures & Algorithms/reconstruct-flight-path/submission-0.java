class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> lis= new ArrayList<>();

       

       // Building the adj list + Outdegree part
        HashMap<String,ArrayList<String>> adj= new HashMap<>();
        int n= tickets.size();
        for (int i=0;i<n;i++){
            
            String u= tickets.get(i).get(0);
            String v= tickets.get(i).get(1);
            if (!adj.containsKey(u)) adj.put(u,new ArrayList<>());

            adj.get(u).add(v);

        }
        for (Map.Entry<String,ArrayList<String>> mp : adj.entrySet()){
            ArrayList<String> li= mp.getValue();
            Collections.sort(li,(a,b)-> b.compareTo(a));
            adj.put(mp.getKey(),li);
        }

        String temp= "JFK";

    

        ArrayDeque<String> dq= new ArrayDeque<>();
        dq.offerLast(temp);

        while(!dq.isEmpty()){
            String u= dq.peekLast();
            if (!adj.containsKey(u) || (adj.containsKey(u) && adj.get(u).size()==0)){
                lis.add(u);
                dq.pollLast();
            }
            else{
                int len=adj.get(u).size();
                String v= adj.get(u).get(len-1);
                adj.get(u).remove(len-1);
                dq.offerLast(v);
            }
            
        }

        
        Collections.reverse(lis);
        return lis;

        
    }
}
