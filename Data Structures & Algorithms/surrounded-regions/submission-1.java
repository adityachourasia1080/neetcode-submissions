class Solution {
    int x[]={0,1,0,-1};
    int y[]={1,0,-1,0};

    private void dfs(char[][]board,int i,int j){
        board[i][j]='#';
        for (int k=0;k<4;k++){
                int nx= x[k]+i;
                int ny= y[k]+j;
                if (nx<0 || nx>=board.length || ny<0 || ny>=board[0].length || board[nx][ny]!='O') continue;
                dfs(board,nx,ny);
            }
    }
    public void solve(char[][] board) {
        Deque<int[]> q= new ArrayDeque<>();
        int n= board.length;
        int m= board[0].length;
        for (int i=0;i<n;i++){
           if (board[i][0]=='O') q.offerLast(new int[]{i,0});
           if (board[i][m-1]=='O')   q.offerLast(new int[]{i,m-1});
        }

        for (int j=1;j<m-1;j++){
            if (board[0][j]=='O') q.offerLast(new int[]{0,j});
           if (board[n-1][j]=='O')   q.offerLast(new int[]{n-1,j});
        }

        while(!q.isEmpty()){
            int[] temp= q.pollFirst();
            int i= temp[0];
            int j= temp[1];
             
            if(board[i][j]=='#') continue;

            dfs(board,i,j);

        }

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (board[i][j]=='O') board[i][j]='X';
                else if (board[i][j]=='#') board[i][j]='O';
            }
        }
        
    }
}
