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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> remove = new HashSet<>();
        for(int num: nums){
            remove.add(num);
        }
        ListNode demo = new ListNode(0);
        demo.next = head;
        ListNode current = demo;
        while(current.next != null){
            if(remove.contains(current.next.val)){
                current.next = current.next.next;
            }else{
            current = current.next;
            }
        }
        return demo.next;
    }
}