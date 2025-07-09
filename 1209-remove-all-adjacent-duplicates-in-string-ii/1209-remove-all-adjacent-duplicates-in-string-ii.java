class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<pair> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(!st.isEmpty() && ch==st.peek().ch){
                st.peek().cnt++;
                if(st.peek().cnt==k) st.pop();
            }
            else st.push(new pair(ch,1));
        }
        StringBuilder str = new StringBuilder();
        for(pair p: st) {
            for(int i=0;i<p.cnt;i++) str.append(p.ch);
        }
        return str.toString();
    }
    class pair{
        char ch;
        int cnt;
        pair(char ch, int cnt){
            this.ch=ch;
            this.cnt=cnt;
        }
    }
}