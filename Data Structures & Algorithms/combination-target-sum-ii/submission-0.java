class Solution {
    private void find(int[]nums,int target,List<Integer>temp,List<List<Integer>>ans,int l,int h){
        if (target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i=l;i<h;i++){
            if (i>l && nums[i]==nums[i-1]) continue;
            if (nums[i]>target)  return ;
            temp.add(nums[i]);
            find(nums,target-nums[i],temp,ans,i+1,h);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(candidates);

        find(candidates,target,temp,ans,0,candidates.length);
        return ans;
        
    }
}
