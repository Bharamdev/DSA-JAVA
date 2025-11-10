class Solution {
    public int minOperations(int[] nums) {
        int cnt=0;
        Stack<Integer> st = new Stack<>();
        for(int num: nums){
            while(!st.isEmpty() && st.peek()>num) st.pop();
            if(num==0) continue;
            if(st.isEmpty() || st.peek()<num){
                cnt++;
                st.push(num);
            }
        }
        return cnt;
    }
}