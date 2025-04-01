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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null) return head;
        int cnt=1;
        ListNode temp=head;
        ListNode a = null;
        ListNode b = null;
        while(temp.next!=null){
            cnt++;
            temp=temp.next;
        }
        if (k > cnt) return head; 
        int x=1;
        temp=head;
        // while(temp!=null){
        //     if(x==k) a=temp;
        //     if(x==(cnt-k+1)) b=temp;
        //     temp=temp.next;
        // }
        if(a==null || b==null) return head;
        int temp2 = a.val;
        a.val=b.val;
        b.val=temp2;
        return head;
    }
}