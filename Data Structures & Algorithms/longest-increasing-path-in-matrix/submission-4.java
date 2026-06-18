class Solution {
    int x[]={1,0,-1,0};
    int y[]={0,1,0,-1};

    private boolean isValid(int mat[][],int freq[][],int nx,int ny,int ox,int oy){
        if (nx>=0 && nx<freq.length && ny>=0 && ny<freq[0].length && mat[nx][ny]>mat[ox][oy] )  return true;
        return false;
    }
    private int dfs(int mat[][],int i,int j,int freq[][]){

        if (freq[i][j]!=-1)  return freq[i][j];
         int nx;
         int ny;
         int ans=1;
         int temp=1;
        for (int k=0;k<4;k++){
           
            nx= i+x[k];
            ny= j+y[k];

            if (isValid(mat,freq,nx,ny,i,j)){
               temp= dfs(mat,nx,ny,freq);
               ans=Math.max(temp+1,ans);
            }
        }

        return freq[i][j]= ans;
    }

    public int longestIncreasingPath(int[][] mat) {
        int n= mat.length;
        int m= mat[0].length;

        int freq[][]= new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                freq[i][j]=-1;
            }
        }

        int ans=1;

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (freq[i][j]==-1){
                    freq[i][j]=dfs(mat,i,j,freq);
                    ans=Math.max(ans,freq[i][j]);
                }
            }
        }

        return ans;
        
    }
}
