/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> mp= new HashMap<>();
        Queue<Node>q=  new LinkedList<>();
        if (node ==null)  return null;
        mp.put(node, new Node(node.val));

        q.add(node);


        while(!q.isEmpty()){
            Node curr= q.poll();
            for (Node neigh: curr.neighbors){
                if (mp.containsKey(neigh)){
                    mp.get(curr).neighbors.add(mp.get(neigh));
                }
                else{
                    mp.put(neigh, new Node(neigh.val));
                    mp.get(curr).neighbors.add(mp.get(neigh));
                    q.add(neigh);
                }
            }
        }

        return mp.get(node);
        
    }
}