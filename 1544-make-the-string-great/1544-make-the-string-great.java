class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && Math.abs(st.peek()-ch)==32) st.pop();
            else st.push(ch);
        }
        int size=st.size();
        for(int i=0;i<size;i++){
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}