class Solution {

    private double find(int[] nums1,int[] nums2){
         int n= nums1.length,m=nums2.length;
         int low=0,high=n;
         while(low<=high){
            int i1= low+(high-low)/2;
            int i2=((n+m+1)/2)-i1;

            int high1= (i1==0)? Integer.MIN_VALUE : nums1[i1-1];
            int low1 =(i1==n)?Integer.MAX_VALUE : nums1[i1];

            int high2 =(i2==0)? Integer.MIN_VALUE: nums2[i2-1];
            int low2 =(i2==m)? Integer.MAX_VALUE: nums2[i2];

            if (high2<=low1 && high1<=low2){
                if ((n+m)%2!=0){
                    return (double)Math.max(high1,high2);
                }
                double ans= ((double)Math.max(high1,high2)+(double)Math.min(low1,low2))/2;
                return ans;
            }
            else if (high1 > low2){
                high=i1-1;
            }
            else low=i1+1;

         }
         return -1;

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n= nums1.length,m=nums2.length;

        if (n>m)  return find(nums2,nums1);

        return find(nums1,nums2);
        
    }
}