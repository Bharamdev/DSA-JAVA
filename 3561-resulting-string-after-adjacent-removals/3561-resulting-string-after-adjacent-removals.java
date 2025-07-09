class Solution {
    public String resultingString(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(!st.isEmpty() && check(ch,st.peek())){
                st.pop();
            }
            else st.push(ch);
        }
        StringBuilder str = new StringBuilder();
        for(char ch: st) str.append(ch);
        return str.toString();
    }
    public boolean check(char a, char b){
        if((a=='z' && b=='a') || (a=='a' && b=='z')) return true;
        return Math.abs(a-b)==1;
    }
}