class Solution {
    public void rotate(int[][] mat) {
        int n= mat.length;
        int m= mat[0].length;

       //reverse row
        for (int j=0;j<m;j++){
            int l=0,h=n-1;
            while(l<h){
                int temp= mat[l][j];
                mat[l][j]=mat[h][j];
                mat[h][j]=temp;
                l++;
                h--;
            }
        }

        //transpose
        for (int i=0;i<n;i++){
            for (int j=i+1;j<m;j++){
                int temp= mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        
    }
}
