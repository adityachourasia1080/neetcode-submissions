class Solution {
    public int trap(int[] ht) {
        int n= ht.length;
        if (n==1)  return 0;
        int lmax=ht[0];
        int rmax=ht[n-1];

        int l=1,r=n-2;
        int ans=0;
        while(l<=r){
            if (lmax>rmax){
                int k= rmax-ht[r];
                if (k>0) ans+=k;
                rmax=Math.max(ht[r],rmax);
                r--;
            }
            else{
                int k= lmax-ht[l];
                if(k>0) ans+=k;
                lmax=Math.max(ht[l],lmax);
                l++;
            }
        }

        return ans;

    }
}
