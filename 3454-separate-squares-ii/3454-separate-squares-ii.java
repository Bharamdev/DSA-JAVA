import java.util.*;

class Solution {

    static class Event {
        long y;
        int x1, x2;
        int type;
        Event(long y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegTree {
        int n;
        int[] count;
        long[] length;
        long[] xs;

        SegTree(long[] xs) {
            this.xs = xs;
            n = xs.length - 1;
            count = new int[4 * n];
            length = new long[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (qr <= l || r <= ql) return;
            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int m = (l + r) / 2;
                update(node * 2, l, m, ql, qr, val);
                update(node * 2 + 1, m, r, ql, qr, val);
            }
            if (count[node] > 0) {
                length[node] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                length[node] = 0;
            } else {
                length[node] = length[node * 2] + length[node * 2 + 1];
            }
        }

        void update(int l, int r, int val) {
            update(1, 0, n, l, r, val);
        }

        long query() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {
        List<Long> xvals = new ArrayList<>();
        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            long x1 = s[0], y1 = s[1], l = s[2];
            long x2 = x1 + l;
            xvals.add(x1);
            xvals.add(x2);
            events.add(new Event(y1, 0, 0, +1));
            events.add(new Event(y1 + l, 0, 0, -1));
        }

        Collections.sort(xvals);
        long[] xs = xvals.stream().distinct().mapToLong(Long::longValue).toArray();

        Map<Long, Integer> idx = new HashMap<>();
        for (int i = 0; i < xs.length; i++) idx.put(xs[i], i);

        int e = 0;
        for (int[] s : squares) {
            long x1 = s[0], y1 = s[1], l = s[2];
            long x2 = x1 + l;
            events.get(e++).x1 = idx.get(x1);
            events.get(e - 1).x2 = idx.get(x2);
            events.get(e++).x1 = idx.get(x1);
            events.get(e - 1).x2 = idx.get(x2);
        }

        events.sort(Comparator.comparingLong(a -> a.y));
        SegTree st = new SegTree(xs);

        double total = 0;
        long prevY = events.get(0).y;

        for (Event ev : events) {
            total += (ev.y - prevY) * st.query();
            st.update(ev.x1, ev.x2, ev.type);
            prevY = ev.y;
        }

        double half = total / 2;
        st = new SegTree(xs);
        prevY = events.get(0).y;
        double cur = 0;

        for (Event ev : events) {
            double slab = (ev.y - prevY) * st.query();
            if (cur + slab >= half) {
                return prevY + (half - cur) / st.query();
            }
            cur += slab;
            st.update(ev.x1, ev.x2, ev.type);
            prevY = ev.y;
        }
        return prevY;
    }
}