// User function Template for Java

class Solution {
    int replaceBit(int N, int K) {
        int num = N;
        int len=0;
        while(N>0){
            N=N>>1;
            len++;
        }
        if(K>len) return num;
        int pos = len-K;
        num = num & ~(1<<pos);
        return num;
    }
}