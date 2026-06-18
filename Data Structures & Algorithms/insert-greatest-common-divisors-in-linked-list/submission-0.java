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
    private int gcd(int a,int b){
        if (a==0)  return b;
        if (b==0)   return a;
        if (a>b)   return gcd(a%b,b);
        return gcd(a,b%a);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr= head, next=null;

        while(curr.next!=null){
            next= curr.next;

            int temp = gcd(curr.val,next.val);

            ListNode read= new ListNode(temp);
            curr.next=read;
            read.next= next;
            curr= next;

        }

        return head;
    }
}