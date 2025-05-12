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
    public int getDecimalValue(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }
        int n= arr.size();
        int ans=0;
        for(int i=n-1;i>=0;i--){
            ans += arr.get(i)*(Math.pow(2,n-1-i));
        }
        return ans;
    }
}