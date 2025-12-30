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
    public void reorderList(ListNode head) {
        ListNode slow=head, fast=head;
        //find mid
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse second half
        ListNode prev=null, curr=slow.next;
        slow.next=null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        // merge two halves
        ListNode first=head, second=prev;
        while(second!=null){
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first=t1;
            second=t2;
        }
    }
}