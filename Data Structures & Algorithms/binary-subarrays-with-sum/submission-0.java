class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        // prefix sum
        HashMap<Integer,Integer> mp= new HashMap<>();

        int total=0;
        int count=0;
        mp.put(0,1);
        for (int i=0;i<nums.length;i++){
            total+=nums[i];

            int diff= total-goal;
            if (mp.containsKey(diff)){
                count+=mp.get(diff);
            }
            mp.put(total,mp.getOrDefault(total,0)+1);
            
        }

        return count;

        
    }
}