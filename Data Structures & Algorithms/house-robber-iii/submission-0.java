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
        if(root==null)  return new int[]{0,0};

        int left[]= find(root.left);
        int right[]= find(root.right);

        int currRob= root.val+left[1]+right[1];
        return new int[]{currRob,Math.max(left[0],left[1])+Math.max(right[0],right[1])};
    }
    public int rob(TreeNode root) {
        int arr[]= find(root);
        return Math.max(arr[0],arr[1]);
        
    }
}