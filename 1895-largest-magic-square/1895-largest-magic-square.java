class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // prefix sums
        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
            }
        }

        // try largest size first
        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {

                    int target = row[i][j + k] - row[i][j];
                    boolean ok = true;

                    // check rows
                    for (int r = i; r < i + k && ok; r++) {
                        if (row[r][j + k] - row[r][j] != target) {
                            ok = false;
                        }
                    }

                    // check columns
                    for (int c = j; c < j + k && ok; c++) {
                        if (col[i + k][c] - col[i][c] != target) {
                            ok = false;
                        }
                    }
                    // check diagonals 
                    int d1 = 0, d2 = 0;
                    for (int t = 0; t < k; t++) {
                        d1 += grid[i + t][j + t];
                        d2 += grid[i + t][j + k - 1 - t];
                    }
                    if (ok && d1 == target && d2 == target) {
                        return k;
                    }
                }
            }
        }
        return 1; // every 1x1 grid is magic
    }
}