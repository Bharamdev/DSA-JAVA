class Solution {
    public int numOfWays(int n) {
        long mod = (long)1e9+7;
        long diff=6, same=6;
        for(int i=2;i<=n;i++){
            long newDiff = (diff*2 + same*2)%mod;
            long newSame = (diff*2 + same*3)%mod;
            diff = newDiff;
            same = newSame;
        }
        return (int)((same+diff)%mod);
    }
}