class Solution {
    private void swap(List<Integer>lis,int pos,int i){
        Integer temp = lis.get(pos);
        lis.set(pos,lis.get(i));
        lis.set(i,temp);
    }
    private void find(List<Integer> lis,List<List<Integer>>ans,int pos,int h){
        if (pos==h){
            ans.add(new ArrayList<>(lis));
            return ;
        }

        for (int i=pos;i<h;i++){
            swap(lis,pos,i);
            find(lis,ans,pos+1,h);
            swap(lis,pos,i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> lis = new ArrayList<>();

        for (int i=0;i<nums.length;i++) lis.add(nums[i]);

        find(lis,ans,0,nums.length);
        return ans;
        
    }
}
