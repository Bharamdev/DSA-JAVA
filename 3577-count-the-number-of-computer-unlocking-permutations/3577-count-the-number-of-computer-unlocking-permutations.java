class Solution {
    public int countPermutations(int[] complexity) {
        long mod = 1000000007;
        int n = complexity.length;
        int root = complexity[0];
        for(int i=1;i<n;i++){
            if(complexity[i]<=root) return 0;
        }
        long ans=1;
        for(int i=1;i<n;i++){
            ans = (ans*i)%mod;
        }
        return (int)ans;
    }
}