class CheckBit {
    static boolean checkKthBit(int n, int k) {
        // code here
        int i = n & (1<<k);
        return i!=0;
    }
}