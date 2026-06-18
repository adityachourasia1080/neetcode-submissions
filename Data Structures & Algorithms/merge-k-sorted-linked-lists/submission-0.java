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

        ListNode head=null;  ListNode temp=null;

        if (prev.val < curr.val){
            head=prev;temp=prev; prev=prev.next;
        }
        else{
            head=curr;temp=curr; curr=curr.next;
        }

        while(prev!=null && curr!=null){
            if (prev.val<curr.val){
                temp.next= prev;
                temp=prev;
                prev=prev.next;
            }
            else{
                temp.next=curr;
                temp=curr;
                curr=curr.next;
            }
        }

        if (prev==null) temp.next=curr;
        else temp.next=prev;

        return head;
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
