class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int curr = st.pop(); // index of cuurent element according to stack
                int psi= st.isEmpty() ? -1 : st.peek(); //index Previous smaller element  
                int nsi = i;  // index of next smaller element
                int area =  heights[curr]*(nsi-psi-1);
                ans = Math.max(ans,area);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int curr = st.pop();
            int psi= st.isEmpty() ? -1 : st.peek(); //index Previous smaller element  
            int nsi = n;
            int area =  heights[curr]*(nsi-psi-1);
            ans = Math.max(ans,area);
        }
        return ans;
    }
}