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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null)  return ans;
        q.offer(root);
        while(!q.isEmpty()){
            int len= q.size();
            List<Integer>lis= new ArrayList<>();
            for (int i=0;i<len;i++){
                TreeNode curr= q.poll();
                lis.add(curr.val);
                if (curr.left!=null) q.add(curr.left);
                if (curr.right!=null) q.add(curr.right);
            }
            ans.add(lis);
        }
        return ans;
        
    }
}
