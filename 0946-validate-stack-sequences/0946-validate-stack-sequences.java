class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n=pushed.length;
        int j=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek()==popped[j]){
                st.pop();
                j++;
            }
        }
        return st.size()==0 ? true : false;
    }
}