class Solution {
    public int countMonobit(int n) {
        int cnt=1;
        int val=1;
        while(val<=n){
            cnt++;
            val = (val<<1) | 1 ;
        }
        return cnt;
    }
}