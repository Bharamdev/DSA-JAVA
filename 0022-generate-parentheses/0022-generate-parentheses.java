class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        fn("", 0, 0, n);
        return ans;
    }
    void fn(String str, int open, int close, int n){
        if(str.length()==2*n){
            ans.add(str);
            return;
        }
        if(open<n){
            fn(str+'(', open+1, close, n);
        }        
        if(close<open){
            fn(str+')', open, close+1, n);
        }
    }
}