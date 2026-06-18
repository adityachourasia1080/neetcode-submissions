class Solution {
    int dirx[]={1,0,-1,0};
    int diry[]={0,1,0,-1};

    private boolean isValid(int x,int y,char[][]b,String w,int len){
        if (x<0 || x>=b.length || y<0 || y>=b[0].length || b[x][y]=='#')   return false;
        return true;
    }

    private boolean dfs(int x,int y,char [][]b,String w,int len){
        
        if (w.charAt(len)!=b[x][y])   return false;
        if (len==w.length()-1)  return true;

        b[x][y]='#';
        for (int i=0;i<4;i++){
            int nx= dirx[i]+x;
            int ny= diry[i]+y;
            if (isValid(nx,ny,b,w,len+1) && dfs(nx,ny,b,w,len+1))  return true;
        }
        b[x][y]=w.charAt(len);

        return false;
    }

    public boolean exist(char[][] b, String w) {
        int n= b.length;
        int m= b[0].length;
        List<int[]>lis= new ArrayList<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (b[i][j]==w.charAt(0)){
                    lis.add(new int[]{i,j});
                }
            }
        }

        int x=0;
        int y=0;
        for (int i=0;i<lis.size();i++){
             x=lis.get(i)[0];
             y= lis.get(i)[1];
            if (dfs(x,y,b,w,0))  return true;
        }

        return false;
        
    }
}