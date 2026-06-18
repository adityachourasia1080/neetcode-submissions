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
    private void find(TreeNode root,int[]maxdis,int dis,ArrayList<Integer>lis){
        if (root==null) return ;
        if (maxdis[0]<dis){
            lis.add(root.val);
            maxdis[0]=dis;
        }

        find(root.right,maxdis,dis+1,lis);
        find(root.left,maxdis,dis+1,lis);
    }
    public List<Integer> rightSideView(TreeNode root) {
        int dis[]=new int[1];
        dis[0]=-1;
        ArrayList<Integer> lis= new ArrayList<>();
        find(root,dis,0,lis);
        return lis;
        
    }
}
