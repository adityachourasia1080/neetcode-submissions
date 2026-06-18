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
    int ans;
    private int findDiameter(TreeNode root){
        if (root==null)  return 0;
        int left= findDiameter(root.left);
        int right= findDiameter(root.right);
        ans=Math.max(ans,left+right+1);

        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        ans=0;
        if (root==null)  return ans;
        int temp= findDiameter(root);

        return ans-1;
        
    }
}
