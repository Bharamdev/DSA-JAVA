class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ans = search(matrix, target);
        if(ans != -1) return true;
        return false;
        
    }
    int search(int[][] matrix, int target){
        int col = matrix[0].length - 1;
        int row=0;
        while(row<matrix.length && col>=0){
            if(target == matrix[row][col]){
                return 1;
            }
            else if(target<matrix[row][col]){
                col--;
            }
            else if(target >matrix[row][col]){
                row++;
            }
        }
        return -1;
    }
}