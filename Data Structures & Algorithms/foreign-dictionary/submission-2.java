class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character,List<Character>> adj = new HashMap<>();
        HashMap<Character,Integer> ind= new HashMap<>();

        StringBuilder str= new StringBuilder();
        int n= words.length;
        if (n==1)  return words[0];

        //indegree map
        for (String word: words){
            for (int i=0;i<word.length();i++){
                ind.putIfAbsent(word.charAt(i),0);
            }
        }


       // adj map 
        for (int i=1;i<n;i++){
             String prev= words[i-1];
             String curr= words[i];

             //  invalid case: prefix conflict
            if (prev.startsWith(curr) && prev.length() > curr.length()) {
                return "";
            }

            for (int j=0;j<Math.min(prev.length(),curr.length());j++){
                if (prev.charAt(j)!=curr.charAt(j)) {
                    adj.putIfAbsent(prev.charAt(j),new ArrayList<Character>());
                    adj.get(prev.charAt(j)).add(curr.charAt(j));
                    
                    ind.put(curr.charAt(j),ind.get(curr.charAt(j))+1);
                    break;

                }
            }
        }
         
         Queue<Character> q= new LinkedList<>();
        for (Map.Entry<Character,Integer> mp : ind.entrySet())
        {
            if (mp.getValue()==0)  q.add(mp.getKey());
        }

        
        while(!q.isEmpty()){
            Character temp= q.poll();
            str.append(temp);
            if (adj.containsKey(temp)){
            for (Character v: adj.get(temp)){
                ind.put(v,ind.get(v)-1);
                if (ind.get(v)==0) {
                    q.add(v);
                }
             }
            }
        }

        // cycle check
        if (str.length() != ind.size()) return "";

        return str.toString();
      
    }
}
