class Solution {
    public boolean isValid(String s) {
        // Stack<Character> st = new Stack<>();
        // for(char ch: s.toCharArray()){
        //     st.push(ch);
        //     int n=st.size();
        //     if(n>=3){
        //         if(st.get(n-3)=='a' && st.get(n-2)=='b' && st.get(n-1)=='c'){
        //             st.pop();
        //             st.pop();
        //             st.pop();
        //         }
        //     }
        // }
        // return st.isEmpty();

        while(s.contains("abc")) s=s.replaceAll("abc","");
        return s.equals("");
    }
}