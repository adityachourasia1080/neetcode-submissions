class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int i=0,l=0,h=0;
        int n=nums.length;
        int sum=0;
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();
        while(i<n-2){

            if (i>0 && nums[i]==nums[i-1]) {
                i++;
                continue;
            }

            l=i+1;
            h=n-1;

            while(l<h){
                sum= nums[i]+nums[l]+nums[h];
                
                if (sum==0){
                    List<Integer>lis= Arrays.asList(nums[i],nums[l],nums[h]);
                    while(l<h && nums[l]==lis.get(1)) l++;
                    while(l<h && nums[h]==lis.get(2)) h--;

                    ans.add(lis);
                }
                else if (sum>0) h--;
                else l++;
            }
            i++; 
            
        }

        return ans;
        
    }
}
