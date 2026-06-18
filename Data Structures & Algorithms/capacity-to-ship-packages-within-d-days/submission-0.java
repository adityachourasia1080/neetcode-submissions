class Solution {
    
    private boolean isSafe(int []w,int mid,int d){
        int count=1;
        int sum=0;

        for(int i=0;i<w.length;i++){
            if (w[i]>mid)  return false;
            sum+=w[i];
            if (sum>mid) {
                count++;
                sum=w[i];
            }
            if (count>d)  return false;
        }
        return true;
    }


    public int shipWithinDays(int[] weights, int days) {
        int l=Integer.MIN_VALUE;
        int h=0;
        int ans=Integer.MAX_VALUE;

        int n= weights.length;
        for (int i=0;i<n;i++){
            l=Math.max(l,weights[i]);
            h+=weights[i];
        }

        while(l<=h){
            int mid= l+(h-l)/2;

            if (isSafe(weights,mid,days)){
                ans=mid;
                h=mid-1;
            }
            else l=mid+1;
        }

        return ans;


        
    }
}