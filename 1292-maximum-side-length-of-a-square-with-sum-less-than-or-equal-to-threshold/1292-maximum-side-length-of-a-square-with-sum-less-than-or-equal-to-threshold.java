class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        // Step 1: Build prefix sum
        int[][] pre = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                        + pre[i - 1][j]
                        + pre[i][j - 1]
                        - pre[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n);

        // Step 2: Binary search on side length
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (isValid(pre, mid, threshold)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    // Step 3: Check if any k x k square has sum <= threshold
    private boolean isValid(int[][] pre, int k, int threshold) {
        int m = pre.length - 1;
        int n = pre[0].length - 1;

        for (int i = k; i <= m; i++) {
            for (int j = k; j <= n; j++) {
                int sum = pre[i][j]
                        - pre[i - k][j]
                        - pre[i][j - k]
                        + pre[i - k][j - k];

                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}