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
    private int count(TreeNode root){
        if (root==null) return 0;
        int left= count(root.left);
        int right= count(root.right);
        return left+right+1;
    } 

    private boolean check(TreeNode root,TreeNode subroot){
        if(root==null && subroot==null) return true;
        if (root==null || subroot==null) return false;
        if (root.val==subroot.val){
            return check(root.left,subroot.left) && check(root.right,subroot.right);
        }
        return false;
    }

    private boolean find(TreeNode root,TreeNode subroot){
        if (root==null) return false;
        if (root.val== subroot.val && check(root,subroot)) return true;
        return (find(root.left,subroot) || find(root.right,subroot));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         int noder= count(root);
         int nodes= count(subRoot);
         if (nodes> noder)  return false;

         return find(root,subRoot);

    }
}
