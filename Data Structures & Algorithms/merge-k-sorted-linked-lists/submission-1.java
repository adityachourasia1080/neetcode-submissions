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
    private ListNode merge(ListNode prev, ListNode curr){
        if (prev==null)  return curr;

        ListNode dummy= new ListNode(Integer.MIN_VALUE);
        ListNode tail=dummy;

        while(prev!=null && curr!=null){
            if (prev.val<curr.val){
                tail.next= prev;
                prev=prev.next;
            }
            else{
                tail.next=curr;
                curr=curr.next;
            }
            tail=tail.next;
        }

        if (prev==null) tail.next=curr;
        else tail.next=prev;

        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length ==0)  return null;
        ListNode prev= null;

        for (int i=0;i<lists.length;i++){
            prev= merge(prev,lists[i]);
        }
        return prev;

    }
}
