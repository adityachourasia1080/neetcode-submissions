class Solution {
    int [][] dir={{0,1},{1,0},{-1,0},{0,-1}};

    private void dfs(int[][]height,int prev,int i,int j,boolean[][]ocean){
        if (i<0 || i>=height.length || j<0 || j>=height[0].length || ocean[i][j])  return;
        if (prev> height[i][j])  return;

        ocean[i][j]=true;
        for (int[]temp: dir){
            dfs(height,height[i][j],i+temp[0],j+temp[1],ocean);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] height) {

        int n= height.length;
        int m= height[0].length;


        boolean [][]pacific = new boolean[n][m];
        boolean [][]atlantic = new boolean [n][m];

        for (int i=0;i<n;i++){
            dfs(height,Integer.MIN_VALUE,i,0,pacific);
            dfs(height,Integer.MIN_VALUE,i,m-1,atlantic);
        }

        for (int i=0;i<m;i++){
            dfs(height,Integer.MIN_VALUE,0,i,pacific);
            dfs(height,Integer.MIN_VALUE,n-1,i,atlantic);
        }

        List<List<Integer>> ans= new ArrayList<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
        
    }
}
