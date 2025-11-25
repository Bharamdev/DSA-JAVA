class Solution {
    public int smallestRepunitDivByK(int k) {
        int num=1;
        for(int i=1;i<=k;i++){
            if(num%k==0) return i;
            num = (num*10 + 1)%k;
        }
        return -1;
    }
}