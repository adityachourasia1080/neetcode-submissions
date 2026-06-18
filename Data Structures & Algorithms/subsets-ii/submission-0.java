class Solution {

    private void find(int []nums,int l,int h,List<Integer> temp,List<List<Integer>> ans){
           ans.add(new ArrayList<>(temp));
           for (int i=l;i<h;i++){
            if(i>l && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            find(nums,i+1,h,temp,ans);
            temp.remove(temp.size()-1);
           }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);

        find(nums,0,nums.length,temp,ans);
        return ans;
    
        
    }
}
