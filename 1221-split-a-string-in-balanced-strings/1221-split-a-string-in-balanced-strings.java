class Solution {
    public int balancedStringSplit(String s) {
        int cnt=0,ans=0;
        for(char ch: s.toCharArray()){
            if(ch=='R') cnt++;
            else cnt--;
            if(cnt==0) ans++;
        }
        return ans;
    }
}