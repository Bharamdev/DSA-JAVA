class Solution {
    int cnt=0;
    boolean[] arr;
    boolean[] rDig;
    boolean[] lDig;
    public int totalNQueens(int n) {
        arr = new boolean[n];
        rDig = new boolean[2*n-1];
        lDig = new boolean[2*n-1];
        fn(0,n);
        return cnt;
    }
    void fn(int row, int n){
        if(row==n){
            cnt++;
            return;
        }
        for(int col=0; col<n; col++){
            if(!arr[col] && !rDig[row+col] && !lDig[n-1+col-row]){
                arr[col]=true;
                rDig[row+col]=true;
                lDig[n-1+col-row]=true;
                fn(row+1, n);
                arr[col]=false;
                rDig[row+col]=false;
                lDig[n-1+col-row]=false;
            }
        }
    }
}