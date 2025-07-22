class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(seen[ch-'a']) continue;
            while(!st.isEmpty() && ch<st.peek() && lastIndex[st.peek()-'a']>i){
                seen[st.pop()-'a']=false;
            }
            st.push(ch);
            seen[ch-'a']=true;
        }
        StringBuilder str = new StringBuilder();
        for(char c: st) str.append(c);
        return str.toString(); 
    }
}