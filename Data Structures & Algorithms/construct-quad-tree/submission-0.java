/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {

   private boolean checkValue(int x, int y, int k, boolean[][] grid) {
    boolean val = grid[x][y];
    for (int i = x; i < x + k; i++) {
        for (int j = y; j < y + k; j++) {
            if (grid[i][j] != val) return false;
        }
    }
    return true;
  }

    private Node buildTree(int x1,int y1,int n,boolean grid[][]){
        if (n==1) return new Node(grid[x1][y1],true);

       boolean sameValue= checkValue(x1,y1,n,grid);
       if(sameValue)  return new Node(grid[x1][y1],true);

        int k= n/2;
        Node temp = new Node(false,false);

        temp.topLeft= buildTree(x1,y1,k,grid);
        
        temp.topRight= buildTree(x1,y1+k,k,grid);

        temp.bottomLeft= buildTree(x1+k,y1,k,grid);

        temp.bottomRight= buildTree(x1+k,y1+k,k,grid);

         return temp;
    }


    public Node construct(int[][] grid) {

        int n= grid.length;
        boolean gri[][]= new boolean[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==1) gri[i][j]=true;
                else gri[i][j]=false;
            }
        }
        return buildTree(0,0,n,gri);
        
    }
}