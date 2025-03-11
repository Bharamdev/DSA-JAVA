class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n= nums.length;
        int[] ans = new int[n];
        for(int i = 2*n-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
            stack.pop();
            }
            if(i<n){
                ans[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i%n]);
        }
        return ans;
    }
}