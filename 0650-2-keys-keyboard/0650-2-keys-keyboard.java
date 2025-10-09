class Solution {
    public int minSteps(int n) {
        if(n==1) return 0;
        return 1 + fn(1,1,n);
    }
    int fn(int current,int prev, int n){
        if(current==n) return 0;
        if(current>n) return Integer.MAX_VALUE/2;
        int copyPaste = 2 + fn(current*2, current, n);
        int paste = 1 + fn(current+prev, prev, n);
        return Math.min(paste, copyPaste);
    }
}