class Solution {
    public void setZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean rowZero=false;
        boolean colZero =false;

        //checking row 
        for (int i=0;i<m;i++){
            if (mat[0][i]==0){
                rowZero=true;
                break;
            }
        }

        //checking column
        for (int i=0;i<n;i++){
            if (mat[i][0]==0){
                colZero=true;
                break;
            }
        }

        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                if (mat[i][j]==0){
                    mat[0][j]=0;
                    mat[i][0]=0;
                }
            }
        }

        for (int i=1;i<m;i++){
            if (mat[0][i]==0){
                for (int j=0;j<n;j++){
                    mat[j][i]=0;
                }
            }
        }

        for (int i=0;i<n;i++){
            if (mat[i][0]==0){
                for (int j=0;j<m;j++){
                    mat[i][j]=0;
                }
            }
        }

        if (rowZero){
            for(int i=0;i<m;i++) mat[0][i]=0;
        }
        if (colZero){
            for (int i=0;i<n;i++) mat[i][0]=0;
        }
        
    }
}
