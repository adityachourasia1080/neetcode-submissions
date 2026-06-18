/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //Mapping in HashMap for deep copy
        if (head==null)  return  null;
        HashMap<Node,Node> mp= new HashMap<>();

        Node prev=null,newhead=null;

        while(head!=null){
           if (!mp.containsKey(head)) mp.put(head,new Node(head.val));

           Node copytemp= mp.get(head);
           Node random = head.random;

           if (random!=null){
             if (!mp.containsKey(random)) mp.put(random,new Node(random.val));
             copytemp.random=mp.get(random);
           }

           if (prev!=null){
            prev.next=copytemp;
            prev=prev.next;
           }
           else{
            prev=copytemp;
            newhead=prev;
           }
           head= head.next;
        }

        return newhead;
        
    }
}
