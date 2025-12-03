// User function Template for Java

class Solution {
    static int toggleBits(int n, int l, int r) {
        // code here
        int len = r-l+1;
        int ans = ((1<<len)-1)<<(l-1);
        return n^ans;
    }
};