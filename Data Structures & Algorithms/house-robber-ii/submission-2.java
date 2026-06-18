class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        if (n==1)  return nums[0];
        if (n<=2)  return Math.max(nums[0],nums[1]);
        int robFirst[]= new int[n];
        robFirst[0]=nums[0];
        robFirst[1]=nums[0];

        int notRobFirst[]= new int[n];
        notRobFirst[0]=0;
        notRobFirst[1]=nums[1];
        
        int maxy=0;
        for (int i=2;i<n;i++){
            if (i!=n-1){
                robFirst[i]=Math.max(nums[i]+robFirst[i-2],robFirst[i-1]);
                maxy=Math.max(maxy,robFirst[i]);
            }
            notRobFirst[i]=Math.max(nums[i]+notRobFirst[i-2],notRobFirst[i-1]);
            maxy=Math.max(maxy,notRobFirst[i]);
        }

        return maxy;
        
    }
}
