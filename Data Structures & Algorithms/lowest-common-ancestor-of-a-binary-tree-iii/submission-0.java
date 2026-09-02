/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {

    private Node findRoot(Node p){
        if (p.parent==null)  return p;
        return findRoot(p.parent);

    }

    private Node lca(Node root,Node p, Node q){
        
        if (root==null)  return null;
        if (root==p || root== q)  return root;
        Node left= lca(root.left,p,q);
        Node right= lca(root.right, p,q);
        if (left!=null && right !=null)  return root;
        if (left!=null)  return left;
        return right ;  
        
    }


    
    public Node lowestCommonAncestor(Node p, Node q) {

        Node root= findRoot(p);
        return lca(root,p,q);
        
    }
}