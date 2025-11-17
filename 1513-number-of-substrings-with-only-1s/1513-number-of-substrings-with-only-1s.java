class Solution {
    public int numSub(String s) {
        long cnt=0;
        long mod = 1000000007;
        long ones=0;
        for(char ch: s.toCharArray()){
            if(ch=='1') ones++;
            else ones=0;
            cnt += ones%mod;
        }
        return (int)(cnt%mod);
    }
}