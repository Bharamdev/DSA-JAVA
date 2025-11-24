class Solution {
    List<String> ans = new ArrayList<>();
    Set<String> vis = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int remove = valid(s);
        generate(s,remove);
        return ans;
    }
    void generate(String s, int k){
        if(vis.contains(s)) return;
        vis.add(s);
        if(k==0){
            if(valid(s)==0){
                ans.add(s);
                return;
            }
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='(' && s.charAt(i)!=')') continue;
            String pre = s.substring(0,i);
            String post = s.substring(i+1);
            generate(pre+post, k-1);
        }
    }
    int valid(String s){
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='(') st.push(ch);
            else if(ch==')'){
                if(!st.isEmpty() && st.peek()=='(') st.pop();
                else st.push(ch);
            }
        }
        return st.size();
    }
}