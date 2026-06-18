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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null)  return l1;
        int rem=0,sum=0;
        ListNode head=null;
        ListNode curr=null;

        while(l1!=null || l2!=null || rem>0){
            sum=0;
            if (l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            sum+=rem;
            ListNode temp= new ListNode(sum%10);
            rem=sum/10;
            if (head==null){
                curr=temp;
                head=temp;
            }
            else{
                curr.next=temp;
                curr=curr.next;
            }
        }


        return head;

    }
}
