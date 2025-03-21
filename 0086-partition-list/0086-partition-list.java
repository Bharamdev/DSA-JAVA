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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode smallHead = small;
        ListNode largeHead = large;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                small.next=temp;
                small=small.next;
            }
            else{
                large.next=temp;
                large=large.next;
            }
            temp=temp.next;
        }
        large.next=null;
        small.next=largeHead.next;
        return smallHead.next;
    }
}