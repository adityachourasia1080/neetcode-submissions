class Solution {
    public boolean searchMatrix(int[][] m, int target) {
        int x=m.length-1;
        int y=0;

        while(x>=0 && y<m[0].length){
            if (m[x][y]==target)  return true;
            else if (m[x][y]>target) x--;
            else y++;
        }
        return false;
        
    }
}
