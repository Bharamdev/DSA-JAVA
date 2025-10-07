class Solution {
    public String removeKdig(String s, int k) {
        // code here
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k-- >0 && !st.isEmpty()){
            st.pop();
        }
        if(st.isEmpty()) return "0";
        StringBuilder str = new StringBuilder();
        for(char ch: st) str.append(ch);
        while(str.length()>0 && str.charAt(0)=='0'){
            str.deleteCharAt(0);
        }
        if(str.length()==0) return "0";
        return str.toString();
    }
}