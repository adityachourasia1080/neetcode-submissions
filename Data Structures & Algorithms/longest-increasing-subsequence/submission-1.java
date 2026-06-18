class Solution {
    private void bs(List<Integer>lis,int k){
        int l=0,h=lis.size()-1;
        int largest=0;
                while(l<=h){
                    int mid=l+(h-l)/2;
                     if (lis.get(mid)>=k){
                        largest=mid;
                        h=mid-1;
                    }
                    else{
                        l=mid+1;
                    }
                }
                lis.set(largest,k);
    }
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        List<Integer> lis= new ArrayList<>();
        lis.add(nums[0]);
        for (int i=1;i<n;i++){
            if (lis.get(lis.size()-1)<nums[i]){
                lis.add(nums[i]);
            }
            else{
                bs(lis,nums[i]);
            }
        }

        return lis.size();
        
    }
}
