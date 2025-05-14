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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }
        Stack<Integer> st = new Stack<>();
        int n= arr.size();
        int[] result = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr.get(i)>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()) result[i]=0;
            else result[i]=st.peek();
            st.push(arr.get(i));
        }
        return result;
    }
}