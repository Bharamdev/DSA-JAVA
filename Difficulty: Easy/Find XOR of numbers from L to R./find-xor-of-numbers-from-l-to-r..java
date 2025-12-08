// User function Template for Java

class Solution {
    public static int findXOR(int l, int r) {
        return xor(l-1) ^ xor(r);
    }
    static int xor(int n){
        if(n%4==1) return 1;
        if(n%4==2) return n+1;
        if(n%4==3) return 0;
        if(n%4==0) return n;
        return 0;
    }
}