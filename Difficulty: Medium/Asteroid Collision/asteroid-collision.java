// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> st = new Stack<>();
        for(int num:asteroids){
            if(num>0) st.push(num);
            else{
                while(!st.isEmpty() && st.peek()>0 &&
                st.peek()<Math.abs(num)){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==Math.abs(num)){
                    st.pop();
                }
                else if(st.isEmpty() || st.peek()<0) st.push(num);
            }
        }
        int size = st.size();
        int[] ans = new int[size];
        for(int i=size-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}
