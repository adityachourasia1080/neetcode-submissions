class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> mp = new HashMap<>();
        int n= nums.length;

        for (int num: nums) mp.put(num,mp.getOrDefault(num,0)+1);
        List<Integer> []bucket = new List[n+1];

        for (Map.Entry<Integer,Integer> e: mp.entrySet()){
            int freq= e.getValue();
            if (bucket[freq]==null)  bucket[freq]= new ArrayList<>();
            bucket[freq].add(e.getKey());
        }

        int [] ans = new int[k];
        int idx=0;
        for (int i=n;i>=1 && idx<k ;i--){
            if (bucket[i]!=null){
                for (int num: bucket[i]){
                    ans[idx++]=num;
                    if (idx==k) break;
                }
            }
        }

        return ans;
        
    }
}
