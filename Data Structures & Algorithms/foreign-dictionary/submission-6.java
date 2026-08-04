class Solution {
    public String foreignDictionary(String[] words) {

        List<List<Integer>>adj= new ArrayList<>();
        HashMap<Integer,Integer> ind= new HashMap<>();
        for (int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }

        //indegree map
        for (String word: words){
            for (int i=0;i<word.length();i++){
                ind.putIfAbsent(word.charAt(i)-'a',0);
            }
        }

        for (int i=1;i<words.length;i++){
            String a= words[i-1];
            String b= words[i];

            if (a.startsWith(b) && a.length() > b.length()) return"";

            for (int j=0;j<Math.min(a.length(),b.length());j++){
                if ( a.charAt(j)!=b.charAt(j)){
                    int u= a.charAt(j)-'a';
                    int v= b.charAt(j)-'a';
                    ind.put(v, ind.get(v)+1);
                    adj.get(u).add(v);
                    break;
                }

            }
        }


        StringBuilder str= new StringBuilder();


        Queue<Integer>q= new LinkedList<>();
        for( Map.Entry<Integer,Integer> e: ind.entrySet()){
            if (e.getValue()==0)  q.offer(e.getKey());
        }


        while(!q.isEmpty()){
            int u= q.poll();
            str.append((char)('a'+u));
           
                List<Integer> temp= adj.get(u);
                for (int v: temp){
                    int deg= ind.get(v);
                    deg--;
                    if (deg!=0) ind.put(v,deg);
                    else q.offer(v);
            }
        }


        if (str.length()!=ind.size())  return "";

        return str.toString();
      
    }
}
