class Solution {

    private void swap(int i,int j, int[] nums){
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {

        int l=0,mid=0,h=nums.length-1;

        while(mid<=h){
            if (nums[mid]==1) mid++;
            else if (nums[mid]==0){
                swap(l,mid,nums);
                l++;
                mid++;
            }
            else{
                swap(mid,h,nums);
                h--;
            }
        }
        
    }
}