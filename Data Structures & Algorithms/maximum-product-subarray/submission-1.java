class Solution {
    public int maxProduct(int[] nums) {
        int maxProd=0;
        int n= nums.length;
        int maxNeg=0,maxPos=0;
        int i=0;
        for (i=0;i<n;i++){
            if (nums[i]!=0){
                maxNeg=nums[i];
                maxPos=nums[i];
                maxProd=nums[i];
                i++;
                break;
            }
        }

        for (;i<n;i++){
            if (nums[i]==0){
                maxNeg=nums[i];
                maxPos=nums[i];
                maxProd=Math.max(nums[i],maxProd);
            }
            else{
                int temp=maxNeg;
                maxNeg= Math.min(maxNeg*nums[i],Math.min(maxPos*nums[i],nums[i]));
                maxPos= Math.max(temp*nums[i],Math.max(maxPos*nums[i],nums[i]));
                maxProd= Math.max(maxProd,maxPos);
            }

        }
        return maxProd;
        
    }
}
