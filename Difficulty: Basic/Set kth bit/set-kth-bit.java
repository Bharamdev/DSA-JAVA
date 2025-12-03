// User function Template for Java
class Solution {
    static int setKthBit(int n, int k) {
        // code here
        long ans = n | (1<<k);
        return (int)ans;
    }
}