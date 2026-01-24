class Solution {
    int cnt=0;
    int findWays(int n) {
        // code here
        if(n%2!=0) return 0;
        solve(n/2,n/2,new StringBuilder());
        return cnt;
    }
    void solve(int open, int close, StringBuilder str){
        if(open==0 && close==0){
            if(isValid(str.toString())) cnt++;
            return;
        }
        if(open>0){
            str.append('(');
            solve(open-1, close, str);
            str.deleteCharAt(str.length()-1);
        }
        if(close>0){
            str.append(')');
            solve(open, close-1, str);
            str.deleteCharAt(str.length()-1);
        }
    }
    boolean isValid(String str){
        int bal=0;
        for(char ch: str.toCharArray()){
            if(ch=='(') bal++;
            else bal--;
            if(bal<0) return false;
        }
        return bal==0;
    }
}
