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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        head=head.next;
        int sum=0;
        while(head!=null){
            sum+=head.val;
            if(head.val==0 && sum!=0){
                dummy.next = new ListNode(sum);
                dummy = dummy.next;
                sum=0;
            }
            head=head.next;
        }
        return res.next;
    }
}