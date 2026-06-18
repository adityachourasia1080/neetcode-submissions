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
    private void findNode(TreeNode root,int []count,int maxValue ){
        if (root==null) return ;

        if (maxValue <= root.val){
            maxValue=root.val;
            count[0]++;
        }

        findNode(root.left,count,maxValue);
        findNode(root.right,count,maxValue);
    }
    public int goodNodes(TreeNode root) {
        int count[]=new int[1];
        if (root==null)  return count[0];

        findNode(root,count,Integer.MIN_VALUE);
        return count[0];
        
    }
}
