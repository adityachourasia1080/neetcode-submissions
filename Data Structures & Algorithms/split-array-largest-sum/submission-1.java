class Solution {

    private boolean isPossible(int []nums,int k,int mid){
        int sum=0;
        int count=1;
        for (int x: nums){
            if (x>mid)   return false;
            sum+=x;

            if (sum>mid){
                count++;
                sum=x;
            }

            if (count>k)  return false;
        }

        return true;
    }

    public int splitArray(int[] nums, int k) {

        int low=Integer.MIN_VALUE;
        int high= 0;

        for (int x: nums){
            low= Math.max(low,x);
            high+=x;
        }

        int ans=-1;

        while(low<=high){
            int mid= low+(high-low)/2;

            if (isPossible(nums,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }

        return ans;
        
    }
}