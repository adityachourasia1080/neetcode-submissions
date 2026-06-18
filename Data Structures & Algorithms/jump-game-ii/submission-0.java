class Solution {
    public int jump(int[] nums) {
        int n= nums.length;
        int min[]= new int[n];
        for (int i=0;i<n;i++)  min[i]=Integer.MAX_VALUE;
        min[0]=0;
        for (int i=1;i<n;i++){
            for (int j=0;j<i;j++){
              if (j+nums[j]>=i){
                min[i]=Math.min(min[i],min[j]+1);
              }
            }
        }
        return min[n-1];
        
    }
}
