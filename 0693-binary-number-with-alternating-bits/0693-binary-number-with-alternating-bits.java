class Solution {
    public boolean hasAlternatingBits(int n) {
        int cnt=(n&1);
        n=n>>1;
        while(n>0){
            if((n&1) != 0) cnt++;
            else cnt--;
            if(cnt>1 || cnt<0) return false;
            n=n>>1;
        }
        return true;
    }
}