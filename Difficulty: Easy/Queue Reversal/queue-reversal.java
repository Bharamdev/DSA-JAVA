class Solution {
    public void reverseQueue(Queue<Integer> q) {
        // code here
        Stack<Integer> st = new Stack<>();
        while(!q.isEmpty()) st.push(q.poll());
        while(!st.isEmpty()) System.out.print(st.pop() + " ");
    }
}