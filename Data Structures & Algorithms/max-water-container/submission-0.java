class Solution {
    public int maxArea(int[] h) {
        int i=0,j=h.length-1;
        int ans=0;
        while(i<j){
            int distance= j-i;

            ans=Math.max(ans,distance*(Math.min(h[i],h[j])));
            if (h[i]>h[j]){
                j--;
            }else i++;
        }

        return ans;
        
    }
}
