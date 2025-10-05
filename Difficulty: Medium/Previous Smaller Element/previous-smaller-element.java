class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        ArrayList<Integer> pse = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<=st.peek()){
                st.pop();
            }
            if(st.isEmpty()) pse.add(-1);
            else pse.add(st.peek());
            st.push(arr[i]);
        }
        return pse;
    }
}