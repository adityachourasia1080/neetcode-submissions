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
    private boolean check(TreeNode root,int l,int h){
        if (root==null)  return true;
        if (root.val>l && root.val<h && check(root.left,l,root.val) && check(root.right,root.val,h)) {
             return true;
        }
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        if (root==null)  return true;
        return check(root,-2000,2000);
    }
}
