class Solution {
    public int trap(int[] ht) {
        int n= ht.length;
        int left[]= new int[n];
        left[0]=ht[0];
        int ans=0;
        int max=ht[n-1];
        for (int i=1;i<n;i++){
           left[i]=Math.max(left[i-1],ht[i]);
        }

        for (int i=n-2;i>=0;i--){
           max=Math.max(max,ht[i]);
           ans+=Math.min(left[i],max)-ht[i];
        }

        return ans;

        
    }
}
