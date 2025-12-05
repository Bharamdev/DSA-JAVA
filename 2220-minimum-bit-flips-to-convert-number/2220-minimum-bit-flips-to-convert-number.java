class Solution {
    public int minBitFlips(int start, int goal) {
        int cnt=0;
        int num = start^goal;
        while(num>0){
            if((num&1)==1) cnt++;
            num=num>>1;
        }
        return cnt;
    }
}