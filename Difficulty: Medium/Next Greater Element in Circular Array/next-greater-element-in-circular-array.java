class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n=arr.length;
        ArrayList<Integer> res= new ArrayList<>(Collections.nCopies(n,-1));
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && arr[st.peek()]< arr[i%n]){
                res.set(st.pop(),arr[i%n]);
            }
            
            if(i<n) st.push(i);
        }
        return res;
    }
}