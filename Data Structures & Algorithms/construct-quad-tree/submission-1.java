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
    private Node build(int[][] grid,int x,int y , int size){
        int bx= x+size;
        int by= y+size;
        int count1=0;
        int count0=0;
        boolean diff=false;
        for(int i=x;i<bx;i++){
            for (int j=y;j<by;j++){
                if (grid[i][j]==1) count1++;
                else count0++;

            }
            if (count1!=0 && count0!=0) {
                diff=true;
                break;
            }
        }

        if (diff==false){
            boolean val= count1!=0 ? true: false;
            return new Node (val,true);
        }

        Node topLeft= build(grid,x,y,size/2);
        Node topRight= build(grid,x,y+(size/2),size/2);
        Node botLeft= build(grid,x+(size/2),y,size/2);
        Node botRight= build(grid,x+(size/2),y+(size/2),size/2);

        return new Node(false, false, topLeft, topRight, botLeft, botRight);


    }
    public Node construct(int[][] grid) {

        return build(grid,0,0,grid.length);
        
    }
}