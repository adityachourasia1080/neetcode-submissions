class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int ans= Integer.MAX_VALUE;
        int n= arr.length;
        int sum=0;
        int i=0,j=0;
        int start=0;
        for (;j<n;j++){
            sum+=Math.abs(x-arr[j]);
            if (j+1-i==k){
               if (sum<ans){
                ans=sum;
                start=i;
               }

               sum-=Math.abs(arr[i]-x);
               i++;
            }
        }
         List<Integer> res= new ArrayList<>();
        for (int h=start;h<start+k;h++) res.add(arr[h]);

        return res;
        
        
    }
}