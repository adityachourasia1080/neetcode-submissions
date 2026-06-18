class Solution {
    private void swap(int nums[],int i ,int j){
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private int lomuto(int []nums,int l,int h){
        int index= l+(int)Math.random()*(h-l);

        swap(nums,h,index);
        int i=l;
        for (int k=l;k<=h;k++){
            if (nums[k]<nums[h]){
                swap(nums,i,k);
                i++;
            }
        }
        swap(nums,i,h);
        return i;
    }
    private void quickSort(int nums[],int l,int h){
        
        if (l<h){
            int partIndex= lomuto(nums,l,h);
            quickSort(nums,l,partIndex-1);
            quickSort(nums,partIndex+1,h);
        }
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
        
    }
}