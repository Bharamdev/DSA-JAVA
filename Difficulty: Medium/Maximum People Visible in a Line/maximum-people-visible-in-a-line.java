class Solution {
    public int maxPeople(int[] arr) {
        // code here
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        // Arrays.fill(left,-1);
        Arrays.fill(right,n-1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(!st.isEmpty()) left[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(!st.isEmpty()) right[i]=st.peek();
            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int leftLen = i-left[i]-1;
            int rightLen = right[i]-i-1;
            ans = Math.max(ans, leftLen+rightLen+1);
        }
        return ans;
    }
}
