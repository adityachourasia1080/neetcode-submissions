class Solution {
    private void back(int n,int index,int k,List<Integer>ans,List<List<Integer>> res){
        if (k==0){
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i= index;i<=n;i++){
            ans.add(i);
            back(n,i+1,k-1,ans,res);
            ans.remove(ans.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>ans= new ArrayList<>();


        back(n,1,k,ans,res);

        return res;
        
    }
}