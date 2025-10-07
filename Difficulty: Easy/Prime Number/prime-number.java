class Solution {
    static boolean isPrime(int n) {
        // code here
        if(n==0 || n==1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}