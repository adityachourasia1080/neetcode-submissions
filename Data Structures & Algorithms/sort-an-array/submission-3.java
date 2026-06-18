class Solution {

     private void swap(int nums[],int i ,int j){
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private void heapify(int nums[],int i,int n){

        int left= (2*i)+1;
        int right= (2*i)+2;
        int index=i;
            if (left<n && nums[left]>nums[index]) index=left;
            if (right<n && nums[right]>nums[index]) index=right;
            if (i!=index){
                swap(nums,i,index);
                heapify(nums,index,n);
            }
            
    }

    private void buildHeap(int nums[]){
        int n= nums.length;
        int i=(n-1)/2;
        for (;i>=0;i--){
            heapify(nums,i,n);
        }
    }

    public int[] sortArray(int[] nums) {
        int n= nums.length;
        buildHeap(nums);
        for(int i=n-1;i>=1;i--){
            swap(nums,0,i);
            heapify(nums,0,i);
        }

        return nums;
        
    }
}