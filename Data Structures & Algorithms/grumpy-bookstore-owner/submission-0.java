class Solution {
    public int maxSatisfied(int[] cust, int[] grumpy, int min) {
        int n= grumpy.length;

        int satisC[]= new int [n];
        int sum=0;
        for (int i=0;i<n;i++){
            if (grumpy[i]==0){
                sum+=cust[i];
            }
            satisC[i]=sum;
        }


        int left=0,right=0;
        sum=0;
        int ans=0;
        while(right<n){
            sum+=cust[right];

            if (right+1>=min){
                int temp= sum;
                temp+= (left-1>=0) ? satisC[left-1] : 0;
                temp+= (right+1<n) ? satisC[n-1]-satisC[right] : 0;

                ans= Math.max(ans, temp);

                sum-= cust[left];
                left++;
            }

            right++;
        }

        return ans;
        
    }
}