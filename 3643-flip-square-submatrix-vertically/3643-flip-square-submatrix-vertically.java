class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int top = x;
        int bottom = x + k - 1;

        while (top < bottom) {
            for (int col = y; col < y + k; col++) {
                int temp = grid[top][col];
                grid[top][col] = grid[bottom][col];
                grid[bottom][col] = temp;
            }
            top++;
            bottom--;
        }

        return grid;
    }
}
