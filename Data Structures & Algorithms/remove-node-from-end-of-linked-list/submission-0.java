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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null)  return head;

        ListNode prev=null,curr=head,temp=head;
        while(n!=0){
            temp= temp.next;
            n--;
        }

        while(temp!=null){
            temp= temp.next;
            prev=curr;
            curr=curr.next;
        }

        if (prev==null)  return curr.next;
        else{
            prev.next=curr.next;
        }

        return head;

    }
}
