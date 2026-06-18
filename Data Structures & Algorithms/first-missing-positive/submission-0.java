class Solution {

    private void swap(int []nums,int x,int y){
        int temp= nums[x];
        nums[x]= nums[y];
        nums[y]=temp;   
    }

    public int firstMissingPositive(int[] nums) {

        for (int i=0;i<nums.length;i++){
            if (i+1==nums[i]) continue;

            int index =nums[i];
            if (index>=1 && index<=nums.length && nums[index-1]!=index){
                swap(nums,index-1,i);
                i--;
            }
        }


        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i+1)  return i+1;
        }

        return nums.length+1;

    }
}