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

        int left[]= find(root.left);
        int right[]= find(root.right);

        int rob= left[0]+root.val+right[0];

        int notRob= Math.max(left[0]+right[0],Math.max(left[1]+right[0],Math.max(left[0]+right[1],left[1]+right[1])));

        return new int[]{notRob,rob};
    }
    public int rob(TreeNode root) {

        int temp[]= find(root);

        return Math.max(temp[0],temp[1]);
        
    }
}