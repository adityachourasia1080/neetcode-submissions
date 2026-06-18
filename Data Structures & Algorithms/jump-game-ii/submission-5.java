class Solution {
    public int jump(int[] nums) {
        int n= nums.length;
        if (n==1)  return 0;
        int l=0,h=0;
        int steps=0;
        while(l<n){
            int max=-1;
            for (int i=l;i<=h;i++){
               max=Math.max(max,i+nums[i]);
            }
            if (max>=n-1)  return steps+1;
            steps++;
            l=h+1;
            h=max;
        }

        return -1;

        
    }
}
