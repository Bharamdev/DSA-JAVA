class Solution {
    static class Pair {
        long sum;
        int i;
        Pair(long s, int i) {
            sum = s;
            this.i = i;
        }
    }
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        long[] val = new long[n];
        for(int i=0;i<n;i++) val[i]=nums[i];
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] alive = new boolean[n];
        for(int i=0;i<n;i++){
            prev[i] = i-1;
            next[i] = i+1;
            alive[i] = true;
        }
        next[n-1]=-1;
        int badcnt=0;
        for(int i=0;i<n-1;i++){
            if(val[i]>val[i+1]) badcnt++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.sum != b.sum ? Long.compare(a.sum, b.sum)
                                    : Integer.compare(a.i, b.i)
        );
        for(int i=0;i<n-1;i++){
            pq.offer(new Pair(val[i]+val[i+1], i));
        }
        int ops=0;
        while(badcnt>0){
            Pair p;
            while (true) {
                p = pq.poll();
                int i = p.i;
                int j = (i == -1 ? -1 : next[i]);

                if (i != -1 && j != -1 &&
                    alive[i] && alive[j] &&
                    val[i] + val[j] == p.sum) {
                    break;
                }
            }
            int i = p.i;
            int j = next[i];
            int pi = prev[i];
            int nj = next[j];

            // remove old bad pairs
            if(pi!=-1 && val[pi]>val[i]) badcnt--;
            if(val[i]>val[j]) badcnt--;
            if(nj!=-1 && val[j]>val[nj]) badcnt--;

            // merge j into i
            val[i] += val[j];
            alive[j]=false;
            next[i] = nj;
            if(nj!=-1) prev[nj]=i;

            // add new bad pairs
            if(pi!=-1 && val[pi]>val[i]) badcnt++;
            if(nj!=-1 && val[i]>val[nj]) badcnt++;
            
            // push new adjacent pair
            if(pi!=-1) pq.offer(new Pair(val[pi]+val[i], pi));
            if(nj!=-1) pq.offer(new Pair(val[i]+val[nj], i));
            ops++;
        }
        return ops;
    }
}