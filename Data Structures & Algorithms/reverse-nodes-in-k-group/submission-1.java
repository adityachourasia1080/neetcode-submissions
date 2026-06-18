/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head==null || head.next==null || k==1)  return head;

        //count k nodes
        ListNode temp= head,prev=null,next=null;
        int count=0;
        while(temp!=null && count<k){
            prev=temp;
            temp=temp.next;
            count++;
        }

        if (count<k)  return head;
        
        next= prev.next;
        prev.next=null;

        //call for recursion
        ListNode getNode= reverseKGroup(next, k);

        //reverse the curr group from head to prev;
        ListNode curr1=head,prev1=null,next1=null;
        while(curr1!=null){
            next1= curr1.next;
            curr1.next=prev1;
            prev1=curr1;
            curr1=next1;
        }

        head.next= getNode;

        return prev1;
        


        
    }
}
