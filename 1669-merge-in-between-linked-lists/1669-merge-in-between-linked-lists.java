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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = list1;
        for(int i=0;i<a-1;i++){
            prev = prev.next;
        }
        ListNode after = prev;
        for(int i=0;i<=b-a;i++){
            after=after.next;
        }
        ListNode tail = list2;
        while(tail.next!=null){
            tail=tail.next;
        }
        prev.next = list2;
        tail.next = after.next;
        return list1;
    }
}