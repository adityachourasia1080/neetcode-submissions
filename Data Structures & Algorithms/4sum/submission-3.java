class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      Arrays.sort(nums);

      List<List<Integer>>ans= new ArrayList<>();
      int n= nums.length;
      if (n<4)  return ans;
      long sum=0;
      for (int i=0;i<n-3;i++){
        if (i>0 && nums[i]==nums[i-1]) continue;
        for (int j=i+1;j<n-2;j++){
          if (j>i+1 && nums[j]==nums[j-1]) continue;
          int x=j+1,y=n-1;
          
       
          while(x<y){
            sum= (long)nums[i]+nums[j]+nums[x]+nums[y];

            if (sum==target){
              List<Integer>lis= new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[x],nums[y]));
              ans.add(lis);
              while(x<y && nums[x]==lis.get(2)) x++;
              while(x<y && nums[y]==lis.get(3)) y--;
            }
            else if (sum>target) y--;
            else x++;

          }
        }
      }

      return ans;
        
    }
}