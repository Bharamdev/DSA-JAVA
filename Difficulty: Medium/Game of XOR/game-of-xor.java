class Solution {
    public int subarrayXor(int[] arr) {
        // code here
        int n = arr.length;
        if(n%2==0) return 0;
        int xor = 0;
        for(int i = 0; i < n; i += 2) {
            xor ^= arr[i];
        }
        return xor;
    }
}