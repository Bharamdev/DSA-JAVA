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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        ListNode last=head;
        ListNode temp=head;
        int size=1;
        while(temp.next!=null){
            temp=temp.next;
            size++;
        }
        temp.next=head;
        k=k%size;
        if(k==0) {
            temp.next=null;
            return head;
        }
        for(int i=0; i<size-k-1; i++){
            last=last.next;
        }
        ListNode front = last.next;
        last.next=null;
        return front;
    }
}