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

public class Codec {
    int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str= new StringBuilder();
        Deque<TreeNode> st= new ArrayDeque<>();
        TreeNode temp= root;

        while(!st.isEmpty() || temp!=null){
            if (temp==null){
               str.append("#");
               temp = st.pollLast();
               temp=temp.right;
            }
            else{
                str.append(temp.val);
                st.offerLast(temp);
                temp=temp.left;
            }
            str.append(" ");
        }
        this.index=0;
        return str.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       if (index>=data.length())  return null;
       if (data.charAt(index)=='#'){
        index=index+2;
        return null;
       }
        int i=index;
       while(data.charAt(index)!=' ')  index++;

       Integer val= Integer.parseInt(data.substring(i,index));
       TreeNode temp= new TreeNode(val);
       index++;

       temp.left= deserialize(data);
       temp.right= deserialize(data);
       return temp;

        
    }
}
