class Solution {
    int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    private boolean dfs(char[][]board,int x,int y,String word,int index){
        index++;
        if (index==word.length())  return true;

        for (int [] temp:dir){
            int nx= x+temp[0];
            int ny= y+temp[1];

            if (nx>=0 && nx<board.length && ny>=0 && ny<board[0].length && board[nx][ny]==word.charAt(index) ){
              char c= board[x][y];
              board[x][y]='#';
              boolean has= dfs(board,nx,ny,word,index);
              board[x][y]=c;
              if (has)  return true;
            }
        }

        return false;

    }
    public boolean exist(char[][] board, String word) {
        int n= board.length;
        int m= board[0].length;
        List<int[]>lis= new ArrayList<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (board[i][j]==word.charAt(0)) lis.add(new int[]{i,j});
            }
        }

        for (int i=0;i<lis.size();i++){
            int []temp= lis.get(i);
            int x= temp[0];
            int y= temp[1];

            if (dfs(board,x,y,word,0))  return true;
        }

        return false;
        
    }
}
