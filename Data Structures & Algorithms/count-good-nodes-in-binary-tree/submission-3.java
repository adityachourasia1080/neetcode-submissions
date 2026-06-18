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
    public int goodNodes(TreeNode root) {
        TreeNode temp= root;
        int count=0;
        Integer max= Integer.MIN_VALUE;
        HashMap<TreeNode,Integer> mp = new HashMap<>();

        while(temp!=null){
            if (temp.left==null){
                if (temp.val>= max){
                    max=temp.val;
                    count++;
                }
                temp= temp.right;

            }else{
                TreeNode next= temp.left;

                while(next.right!=null && next.right!=temp){
                    next= next.right;
                }

                if (next.right==null){
                     if (temp.val>= max){
                    max=temp.val;
                    count++;
                   }
                    mp.put(temp,max);
                    next.right=temp;
                    temp= temp.left;
                }
                else{
                    next.right=null;
                    max= mp.get(temp);
                    temp= temp.right;
                }
            }
        }

        return count;
        
    }
}
