// User function Template for Java

class Solution {
    static int findPosition(int N, int M, int K) {
        // code here
        int x = M+(K-1);
        int rem = x%N;
        if(rem==0) return N;
        return rem;
    }
};