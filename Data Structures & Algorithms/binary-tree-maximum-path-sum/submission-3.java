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
    public int maxPathSum(TreeNode root){
        ans=Integer.MIN_VALUE;
        PathSum(root);
         return ans;

    }
    public int PathSum(TreeNode root) {

        if(root==null)  return 0;

        int val= root.val;

        int left= PathSum(root.left);
        int right= PathSum(root.right);

        ans=Math.max(ans,val);
        ans=Math.max(ans, left+val);
        ans= Math.max(ans,right+val);
        ans=Math.max(ans,right+left+val);

        return Math.max(val,Math.max(left+val,right+val));
        
    }
}
