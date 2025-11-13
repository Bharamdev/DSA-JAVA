class Solution {
    public int maxOperations(String s) {
        int one=0;
        int cnt=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='1') one++;
            if(s.charAt(i)=='1' && s.charAt(i+1)=='0') cnt+=one;
        }
        return cnt;
    }
}