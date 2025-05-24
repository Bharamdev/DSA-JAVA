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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode node:lists){
           while(node!=null){
                pq.offer(node.val);
                node=node.next;
           }
        }
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        while(!pq.isEmpty()){
            ListNode curr = new ListNode(pq.poll());
            dummy.next=curr;
            dummy=dummy.next;
        } 
        return ans.next;
    }
}