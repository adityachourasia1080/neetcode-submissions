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
    TreeNode temp;
    int k;
    private boolean findKth(TreeNode root){
        if (root==null)  return false;

        if(findKth(root.left))  return true;
        k--;
        if (k==0){
            temp= root;
            return true;
        }
        return findKth(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        findKth(root);
        return temp.val;
       
        
        
    }
}
