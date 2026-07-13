class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int x=0,y=0;
        int ans=1;
        int count=0;
        for (int i=1;i<arr.length;i++){

            if (arr[i]>arr[i-1]){
                if (x==1){
                     count++;
                }
                else{
                    count=2;
                }
                x=0;
                y=1;
            }
            else if (arr[i]<arr[i-1]){
                if (y==1){
                    count++;
                }
                else{
                    count=2;
                }
                x=1;
                y=0;
            }
            else{
                count=1;
                x=0;
                y=0;
            }

            ans=Math.max(ans,count);
        }

        return ans;
        
    }
}