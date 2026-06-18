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
    class pair{
        public TreeNode curr;
        public int max;

        public pair(TreeNode curr,int max){
            this.curr=curr;
            this.max=max;
        }
    }
    public int goodNodes(TreeNode root) {
        int count=0;
        ArrayDeque<pair> st= new ArrayDeque<>();
        TreeNode temp= root;
        int maxValue=Integer.MIN_VALUE;

        while(temp!=null || !(st.isEmpty())){
            if (temp!=null){
                if (maxValue <=temp.val){
                    count++;
                    maxValue= temp.val;
                }
                st.offerLast(new pair(temp,maxValue));
                temp= temp.left;
            }
            else{
                temp = st.peekLast().curr;
                maxValue= st.pollLast().max;
                temp= temp.right;
            }
        }
        return count;
        
    }
}
