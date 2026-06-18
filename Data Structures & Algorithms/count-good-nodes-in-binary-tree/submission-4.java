/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private void findNodes(TreeNode root, int largest,int count[]){
        if (root==null) return ;
        int value= root.val;
        if (value >= largest){
            count[0]++;
            largest=value;
        }

        findNodes(root.left,largest,count);
        findNodes(root.right,largest,count);
    }
    public int goodNodes(TreeNode root) {

        int count[]={0};
        findNodes(root, -101,count);

        return count[0];
        
    }
}
