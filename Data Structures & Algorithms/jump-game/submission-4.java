class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        
        if (n==1)  return true;
        if (nums[0]==0)  return false;

        int maxJumpPossible=nums[0];

        for (int i=1;i<n-1;i++){
            int canReach=nums[i]+i;
             if (maxJumpPossible>=i){
                maxJumpPossible =Math.max(maxJumpPossible,canReach);
             }
        }
        
        if (maxJumpPossible>=n-1)  return true;

        return false;
        
    }
}
