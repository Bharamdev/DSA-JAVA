class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }
                else heights[j]=0;
            }
            max = Math.max(max, area(heights));
        }
        return max;
    }
    int area(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea=0;
        for(int i=0;i<=n;i++){
            int h = i==n ? 0 : heights[i];
            while(!st.isEmpty() && heights[st.peek()] > h){
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i-st.peek()-1;
                maxArea = Math.max(maxArea, height*width); 
            }
            st.push(i);
        }
        return maxArea;
    }
}