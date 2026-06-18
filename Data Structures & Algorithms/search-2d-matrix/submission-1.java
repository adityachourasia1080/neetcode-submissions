class Solution {
    public boolean searchMatrix(int[][] mat, int target) {

        int n = mat.length;
        int m = mat[0].length;
        int i=0, j= m-1;

        while(i<n && j>=0){
            if (mat[i][j]==target)  return true;
            else if (mat[i][j]>target){
                j--;
            }
            else i++;
        }


        return false;


        
    }
}
