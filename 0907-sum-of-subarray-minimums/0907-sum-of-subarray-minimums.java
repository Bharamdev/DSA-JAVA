class Solution {
    public int sumSubarrayMins(int[] arr) {
        // Next Smaller element
        int[] nse = nsefn(arr);
        // Previous Smaller element
        int[] pse = psefn(arr);
        long total=0;
        int mod=1000000007;
        for(int i=0;i<arr.length;i++){
            long ps = i-pse[i]; // in Previous subarray
            long ns = nse[i]-i; // in next subarray
            total = (total + (ps*ns % mod)*arr[i] % mod) % mod;
        }
        return (int)total;
    }
    int[] nsefn(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
    int[] psefn(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
}