// User function Template for Java
class Solution {
    static int fingerCount(int N) {
        // code here
        int n = N%8;
        if(n==1) return 1;
        if(n==2 || n==0) return 2;
        if(n==3 || n==7) return 3;
        if(n==4 || n==6) return 4;
        if(n==5) return 5;
        return 2;
    }
}