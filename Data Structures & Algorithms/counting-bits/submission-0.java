class Solution {
    public int[] countBits(int n) {
        int lis[]= new int[n+1];
        for (int i=0;i<=n;i++){
            int count=0;
            int no=i;
            while(no!=0){
                no=no&(no-1);
                count++;
            }
            lis[i]=count;
        }
        return lis;
        
    }
}
