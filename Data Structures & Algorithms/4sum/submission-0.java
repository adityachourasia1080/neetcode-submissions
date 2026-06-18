class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n= nums.length;
        List<List<Integer>>res= new ArrayList<>();
        long sum=0;
        for (int i=0;i<n-3;i++){
            if (i!=0 && nums[i]==nums[i-1])continue;

            for (int j=i+1;j<n-2;j++){
                if (j!=i+1 && nums[j]==nums[j-1]) continue;

                int x=j+1,y=n-1;
                while(x<y){
                 sum= (long)nums[i]+nums[j]+nums[x]+nums[y];
                 if (sum==target){
                    List<Integer> temp= new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[x]);
                    temp.add(nums[y]);
                    res.add(temp);
                    while(x<y && nums[x]==temp.get(2)) x++;
                    while(x<y && nums[y]==temp.get(3)) y--;
                  }
                  else if (sum> target){
                    y--;
                  }
                  else x++;
                }
            }
        }

        return res;
        
    }
}