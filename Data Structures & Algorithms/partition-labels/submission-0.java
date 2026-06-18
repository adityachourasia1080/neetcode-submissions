class Solution {
    public List<Integer> partitionLabels(String s) {

        HashMap<Character,Integer> mp = new HashMap<>();
        for (int i=0;i<s.length();i++){
            mp.put(s.charAt(i),i);
        }

        int i=0;
        List<Integer> lis= new ArrayList<>();
        while(i<s.length()){
            int last= mp.get(s.charAt(i));
            if (last==i){
                lis.add(1);
                i++;
            }
            else{
                int j=i;
                for(;j<=last;j++){
                    last=Math.max(last,mp.get(s.charAt(j)));
                }
                lis.add(j-i);
                i=j;
            }
        }

        return lis;
        
    }
}
