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
    private ListNode reverse(ListNode head,int count){
        ListNode prev=null;
        ListNode next=null;
        ListNode curr=head;

        while(count>0){
            next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count--;
        }
        

        head.next=curr;
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count=0;
        if (head==null || head.next==null || left==right)  return head;
        ListNode prev=null,temp=head;

        while(count<left){
            count++;
            if (count==left){
                ListNode curr=reverse(temp,right+1-left);
                if (prev==null)   return curr;
                prev.next=curr;
                break;
            }

            prev=temp;
            temp=temp.next;

        }

        return head;
        
    }
}