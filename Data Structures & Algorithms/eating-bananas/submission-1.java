class Solution {
    private boolean isValid(int []piles,int no,int h){
        int time=0;
        for (int i=0;i<piles.length;i++){
            time+=piles[i]/no;
           if (piles[i]%no!=0) time++;

           if (time> h)  return false;
        }
         
         return true;
    }
    public int minEatingSpeed(int[] piles, int hour) {
        int l=1;
        int h=-1;
        for (int i=0;i<piles.length;i++){
            h=Math.max(h,piles[i]);
        }
        int ans=-1;
        while(l<=h){
            int mid= l+(h-l)/2;
            if (isValid(piles,mid,hour)){
                ans=mid;
                h=mid-1;
            }
            else l=mid+1;
        }

        return ans;
        
    }
}
