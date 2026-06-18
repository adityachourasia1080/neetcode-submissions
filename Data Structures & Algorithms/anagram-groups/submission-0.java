class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans= new ArrayList<>();

        HashMap<String ,List<String>> mp = new HashMap<>();
        for (int i=0;i<strs.length;i++){
            String str= strs[i];

                char[] arr = str.toCharArray();
                Arrays.sort(arr);

                String sorted = new String(arr);
                
                mp.putIfAbsent(sorted, new ArrayList<>());
                mp.get(sorted).add(strs[i]);
        }

        for (Map.Entry<String,List<String>> es:mp.entrySet() ){
            ans.add(es.getValue());
        }
        return ans;
        
    }
}
