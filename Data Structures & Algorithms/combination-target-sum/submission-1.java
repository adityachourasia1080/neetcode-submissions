class Solution {
    private void find(int[] nums, int target, int l,List<Integer> temp,List<List<Integer>>ans){
        if (target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i=l;i<nums.length;i++){

            if (nums[i]>target)  return ;
            if (i>0 && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            find(nums,target-nums[i],i,temp,ans);
            temp.remove(temp.size()-1);

        }

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>>ans= new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp= new ArrayList<>();

        find(nums,target,0,temp,ans);

        return ans;
        
    }
}
