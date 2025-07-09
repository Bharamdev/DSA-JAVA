class Solution {
    public int minAddToMakeValid(String s) {
        // Stack<Character> st = new Stack<>();
        // int cnt=0;
        // int n=s.length();
        // for(int i=0;i<n;i++){
        //     if(s.charAt(i)=='(') st.push(s.charAt(i));
        //     else{
        //         // if(st.isEmpty()) return st.size();
        //         if(!st.isEmpty() && st.peek()=='(') st.pop();
        //         else st.push(s.charAt(i));
        //     }
        // }
        // return st.size();
        int open=0,close=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(') open++;
            else{
                if(open>0) open--;
                else close++;
            }
        }
        return open+close;
    }
}