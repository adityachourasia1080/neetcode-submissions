class Solution {
    private int findSubarray(int nums[],int k){
        int left=0,right=0;
        int ans=0;
        int n= nums.length;
        HashMap<Integer,Integer> mp= new HashMap<>();

        while(right<n){
            mp.put(nums[right],mp.getOrDefault(nums[right],0)+1);

            while(mp.size()>k){
                mp.put(nums[left],mp.get(nums[left])-1);
                if (mp.get(nums[left])==0) mp.remove(nums[left]);
                left++;
            }

            ans+=right+1-left;
            right++;
        }

        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {

        // Subarray with atmost k disticnt element = Subarray with exact k disticnt element + Subarray with atmost k-1 disticnt element
        // so Subarray with exact k disticnt element= Subarray with atmost k disticnt element- Subarray with atmost k-1 disticnt element

        int atmostK = findSubarray(nums, k);
        int atmostK1= findSubarray(nums, k-1);
        return atmostK-atmostK1;
        
    }
}