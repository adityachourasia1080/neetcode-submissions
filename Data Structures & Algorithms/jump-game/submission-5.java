class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        int max=0,curr=0;

        for (int i=0;i<n;i++){
            curr= nums[i]+i;
            if (i<=max){
                max=Math.max(max,curr);
                if (max>=n-1)  return true;
            }
            else return false;
        }

        return false;
        
    }
}
