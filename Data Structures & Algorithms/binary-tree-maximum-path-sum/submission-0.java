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
    int maxSum;
    private int findSum(TreeNode root){
        if (root==null)  return -2000;
        int leftSum= findSum(root.left);
        int rightSum= findSum(root.right);
        maxSum= Math.max(maxSum,Math.max(leftSum+rightSum+root.val,Math.max(root.val,Math.max(leftSum+root.val,rightSum+root.val))));

        return Math.max(root.val,Math.max(leftSum+root.val,rightSum+root.val));

        
    }
    public int maxPathSum(TreeNode root) {

        maxSum=Integer.MIN_VALUE;

         findSum(root);
         return maxSum;
        
    }
}
