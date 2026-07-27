class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum=0;
        int left=0,right=0;
        int n= arr.length;
        int count=0;
        double thres= (double)threshold;

        while(right<n){
            sum+=arr[right];

            if (right+1>=k){
                double avg=  (double) sum / (double)k;
                if (avg>=thres) count++;

                sum-= arr[left];
                left++;
            }
            right++;
        }
        return count;
    }
}