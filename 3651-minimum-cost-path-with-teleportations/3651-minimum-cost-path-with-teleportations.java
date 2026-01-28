import java.util.*;

class Solution {
    static class State {
        int cost, i, j, t;
        State(int c, int i, int j, int t) {
            cost = c; this.i = i; this.j = j; this.t = t;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int INF = Integer.MAX_VALUE;

        int[][][] dist = new int[m][n][k + 1];
        for (int[][] layer : dist)
            for (int[] row : layer)
                Arrays.fill(row, INF);

        // sort all cells by value
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{grid[i][j], i, j});
        cells.sort(Comparator.comparingInt(a -> a[0]));

        // for each teleport layer, track processed cells
        int[] ptr = new int[k + 1];

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        dist[0][0][0] = 0;
        pq.add(new State(0, 0, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int cost = cur.cost, i = cur.i, j = cur.j, t = cur.t;
            if (cost != dist[i][j][t]) continue;
            if (i == m - 1 && j == n - 1) return cost;

            // normal moves
            if (i + 1 < m) {
                int nc = cost + grid[i + 1][j];
                if (nc < dist[i + 1][j][t]) {
                    dist[i + 1][j][t] = nc;
                    pq.add(new State(nc, i + 1, j, t));
                }
            }
            if (j + 1 < n) {
                int nc = cost + grid[i][j + 1];
                if (nc < dist[i][j + 1][t]) {
                    dist[i][j + 1][t] = nc;
                    pq.add(new State(nc, i, j + 1, t));
                }
            }

            // optimized teleport
            if (t < k) {
                int val = grid[i][j];
                while (ptr[t] < cells.size() && cells.get(ptr[t])[0] <= val) {
                    int[] c = cells.get(ptr[t]++);
                    int x = c[1], y = c[2];
                    if (cost < dist[x][y][t + 1]) {
                        dist[x][y][t + 1] = cost;
                        pq.add(new State(cost, x, y, t + 1));
                    }
                }
            }
        }
        return -1;
    }
}