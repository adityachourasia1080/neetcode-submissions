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
    private int[] find(TreeNode root){
        if (root==null)  return new int[]{0,0};
        int tempL[]= find(root.left);
        int tempR[]= find(root.right);

        int first= tempL[1]+tempR[1]+root.val;
        int second= Math.max(tempL[0]+tempR[0], Math.max(tempL[0]+tempR[1],Math.max(tempL[1]+tempR[0],tempL[1]+tempR[1])));

        return new int[]{first,second};
    }
    public int rob(TreeNode root) {

        int temp[] = find(root);
        return Math.max(temp[0],temp[1]);
        
    }
}