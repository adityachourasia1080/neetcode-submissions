class Solution {
    class pair{
        int first;
        int second;
        public pair(int first,int second){
            this.first= first;
            this.second= second;
        }
    }
    public int rob(int[] nums) {

        //first is rob num[0] so u cannot rob nums[n-1]
        //second is not rob nums[n-1] so u can ron nums[n-1];

        int n= nums.length;
        if (n==1)  return nums[0];
        if (n==2)  return Math.max(nums[0],nums[1]);

        pair secondLast = new pair(nums[0],0);
        pair last = new pair(nums[0],nums[1]);

        for (int i=2;i<n-1;i++){
            pair temp = new pair(Math.max(secondLast.first+nums[i],last.first),Math.max(secondLast.second+nums[i],last.second));
            secondLast= last;
            last= temp;
        }
        
        pair res= new pair(last.first,Math.max(last.second,secondLast.second+nums[n-1]));

        return Math.max(res.first,res.second);
        
    }
}
