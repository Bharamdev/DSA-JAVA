class Solution {
    // function to make char[][] and call function queen to get answer
    public List<List<String>> solveNQueens(int n) {
        char[][] arr = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]='.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] upperD = new int[2*n-1];
        int[] lowerD = new int[2*n-1];
        queen(0, arr, ans, leftRow, upperD, lowerD);
        return ans;
    }

    // Function construct to convert char[][] to List<String>>
    public static List<String> construct(char[][] arr){
        List<String> res = new ArrayList<>();
        for(char[] row: arr){
            res.add(new String(row));
        }
        return res;
    }

    // Function to find ans
    public static void queen(int col, char[][]  arr, List<List<String>> ans, 
    int[] leftRow, int[] upperD, int[] lowerD){
        if(col==arr.length){
            ans.add(construct(arr));
            return;
        }
        for(int row=0; row<arr.length; row++){
            if(leftRow[row] ==0 && upperD[col+row]==0 && lowerD[arr.length-1 + col-row]==0){
                arr[row][col] = 'Q';
                leftRow[row] = 1;
                upperD[col+row]=1 ;
                lowerD[arr.length-1 + col-row]=1;
                queen(col+1, arr, ans, leftRow, upperD, lowerD);
                arr[row][col] = '.';
                leftRow[row] = 0;
                upperD[col+row] = 0 ;
                lowerD[arr.length-1 + col-row] = 0 ;
            }
        }
    }

}