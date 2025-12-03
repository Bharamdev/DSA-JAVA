class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        double INF = 1e9 + 7;

        // slope -> list of intercepts
        Map<Double, List<Double>> slopeIntercpts = new HashMap<>();

        // midpointKey -> list of slopes
        Map<Integer, List<Double>> midPointMap = new HashMap<>();

        int result = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dx = x2 - x1;   // FIXED
                int dy = y2 - y1;   // FIXED

                double slope, intercept;

                if (dx == 0) {
                    // vertical line
                    slope = INF;
                    intercept = x1;
                } else {
                    slope = (double) dy / dx;
                    intercept = (double) (y1 * dx - x1 * dy) / dx;
                }

                // normalize negative zero
                if (slope == -0.0) slope = 0.0;
                if (intercept == -0.0) intercept = 0.0;

                int midPointKey = (x1 + x2) * 10000 + (y1 + y2);

                slopeIntercpts
                        .computeIfAbsent(slope, k -> new ArrayList<>())
                        .add(intercept);

                midPointMap
                        .computeIfAbsent(midPointKey, k -> new ArrayList<>())
                        .add(slope);
            }
        }

        // Count trapezoids = pairs of parallel lines with different intercepts
        for (List<Double> interList : slopeIntercpts.values()) {
            if (interList.size() <= 1) continue;

            TreeMap<Double, Integer> mp = new TreeMap<>();
            for (double b : interList)
                mp.put(b, mp.getOrDefault(b, 0) + 1);

            int prefix = 0;
            for (int count : mp.values()) {
                result += prefix * count;
                prefix += count;
            }
        }

        // Remove parallelograms (duplicates)
        for (List<Double> slopeList : midPointMap.values()) {
            if (slopeList.size() <= 1) continue;

            TreeMap<Double, Integer> mp = new TreeMap<>();
            for (double s : slopeList)
                mp.put(s, mp.getOrDefault(s, 0) + 1);

            int prefix = 0;
            for (int count : mp.values()) {
                result -= prefix * count;
                prefix += count;
            }
        }

        return result;
    }
}
