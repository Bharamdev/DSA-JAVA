class Solution {
    public int andInRange(int l, int r) {
        // Code here
        int shift=0; // shift until we not get Common prefix
        while(l<r){
            l >>= 1;
            r >>= 1;
            shift++;
        }
        return l<<shift;
    }
}
