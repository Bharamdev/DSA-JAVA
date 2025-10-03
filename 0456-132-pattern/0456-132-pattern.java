class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int k = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(nums[i]<k) return true;
            while(!st.isEmpty() && nums[i]>st.peek()){
                k = st.pop(); // k = nums[k];
            }
            st.push(nums[i]); // st.peek() = nums[j]
        }
        return false;
    }
}