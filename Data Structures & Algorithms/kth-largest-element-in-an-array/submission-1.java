class Solution {
    private void swap(int nums[],int i,int j){
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private int findPivot(int []nums,int l ,int h){
        int randIndex= l+((int)(Math.random())*(h-l+1));
        int pivotElement= nums[randIndex];
        swap(nums,randIndex,h);
        int i=l;
        for (int j=l;j<=h;j++){
            if (nums[j]< pivotElement){
               swap(nums,i,j);
                i++;
            }
        }

        swap(nums,i,h);
        return i;
    }
    public int findKthLargest(int[] nums, int k) {
        //Using lomuto partition

        int n= nums.length;
        k=(n-k);
        int l=0,h=n-1;
        while(l<=h){
            int pivot= findPivot(nums,l,h);
            if (pivot==k)  return nums[pivot];
            else if (pivot > k){
                h=pivot-1;
            }
            else l=pivot+1;
        }

        return -1;
        
    }
}
