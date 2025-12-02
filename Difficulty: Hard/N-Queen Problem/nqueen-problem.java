class Solution {
    ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ans = new ArrayList<>();
        // boolean[][] q = new boolean[n][n];
        boolean[] arr = new boolean[n];
        boolean[] rdig = new boolean[2*n-1];
        boolean[] ldig = new boolean[2*n-1];
        ArrayList<Integer> list = new ArrayList<>();
        solve(0,n, list, arr, rdig, ldig);
        return ans;
    }
    void solve(int row, int n, ArrayList<Integer> list, 
               boolean[] arr, boolean[] rdig, boolean[] ldig){
        if(row==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int col=0;col<arr.length;col++){
            if(!arr[col] && !rdig[col+row] && !ldig[n-1+col-row]){
                arr[col]=true;
                rdig[col+row]=true;
                ldig[n-1+col-row]=true;
                list.add(col+1);
                solve(row+1, n, list, arr, rdig, ldig);
                arr[col]=false;
                rdig[col+row]=false;
                ldig[n-1+col-row]=false;
                list.remove(list.size()-1);
            }
        }       
    }
}