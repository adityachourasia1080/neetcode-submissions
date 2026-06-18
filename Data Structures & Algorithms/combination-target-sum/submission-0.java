class Solution {

    private void backtrack(int []nums,int low,List<List<Integer>>res,List<Integer> temp,int target){
        if (target==0){
            res.add(new ArrayList<>(temp));
            return ;
        }

        for (int i=low;i<nums.length;i++){
            if (nums[i]<=target){
                temp.add(nums[i]);
                backtrack(nums,i,res,temp,target-nums[i]);
                temp.remove(temp.size()-1);
            }
            else return ;
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>>res= new ArrayList<>();
        List<Integer> temp= new ArrayList<>();

        backtrack(nums,0,res,temp,target);

        return res;
        
    }
}
