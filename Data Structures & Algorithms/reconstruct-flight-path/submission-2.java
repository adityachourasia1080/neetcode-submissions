class Solution {
    public List<String> findItinerary(List<List<String>> t) {

        HashMap<String,List<String>>mp= new HashMap<>();
        // construct adj matrix
        for (List<String>st: t){
            String u= st.get(0);
            String v= st.get(1);

            mp.putIfAbsent(u,new ArrayList<>());
            mp.get(u).add(v);

        }

        for (Map.Entry<String,List<String>> mpe : mp.entrySet()){
            List<String> li= mpe.getValue();
            Collections.sort(li,(a,b)-> b.compareTo(a));
            mp.put(mpe.getKey(),li);
        }

        String start= "JFK";


        Deque<String> st= new ArrayDeque<>();
        st.offerLast(start);

        List<String>ans= new ArrayList<>();


        while(!st.isEmpty()){
            String temp= st.peekLast();
            if (!mp.containsKey(temp) || (mp.containsKey(temp) && mp.get(temp).size()==0)){
               ans.add(st.pollLast());
            }
            else{
                List<String> dup= mp.get(temp);
                String rem= dup.get(dup.size()-1);
                dup.remove(dup.size()-1);
                mp.put(temp,dup);
                st.offerLast(rem);
            }

        }


        Collections.reverse(ans);
       return ans;

        
    }
}
