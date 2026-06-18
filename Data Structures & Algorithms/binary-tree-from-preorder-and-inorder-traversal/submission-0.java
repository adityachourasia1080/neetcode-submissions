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
    int pre;
    private TreeNode build(int[] preorder,HashMap<Integer,Integer> mp,int l,int h){
        if (l<=h){
            int value= preorder[pre++];
            TreeNode curr= new TreeNode(value);
            curr.left= build(preorder,mp,l,mp.get(value)-1);
            curr.right= build(preorder,mp,mp.get(value)+1,h);
            return curr;
        }
        return null;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }

        return build(preorder,mp,0,inorder.length-1);
        
    }
}
