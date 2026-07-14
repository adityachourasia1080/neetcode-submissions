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

    // Encodes a tree to a single string.
    int index;
    private void doSerialise(TreeNode root,StringBuilder str){
        if (root==null){
            str.append('#');
            str.append(' ');
            return ;
        }
        StringBuilder temp= new StringBuilder();
        temp.append(root.val);
        str.append(temp.toString());
        str.append(' ');
        doSerialise(root.left,str);
        doSerialise(root.right,str);
    }

    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        doSerialise(root,str);
        index=0;
        System.out.println(str.toString());
        return str.toString();
    }

  
    public TreeNode deserialize(String data) {
        int k = data.indexOf(' ',index);
        String temp= data.substring(index,k);
        index=k+1;
        System.out.println(temp);
        //if (temp.length()==0)  return null;
        if ( temp.charAt(0)=='#'){
            return null;
        }

        Integer no= Integer.parseInt(temp);
       TreeNode node= new TreeNode(no);

       node.left= deserialize(data);
       node.right= deserialize(data);

       return node;

        
    }
}
