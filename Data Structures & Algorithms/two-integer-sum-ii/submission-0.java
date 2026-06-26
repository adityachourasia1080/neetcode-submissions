class Solution {
    public int[] twoSum(int[] n, int target) {

        int ans[]= new int[2];
        int low= 0,high=n.length-1;

        while(low<high){
            int sum= n[low]+n[high];
            if (sum==target)  return new int[]{low+1,high+1};
            else if (sum>target) high--;
            else low++;
        }

        return ans;
        
    }
}