class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        int[] primes = {2,3,5};
        pq.offer(1L);
        set.add(1L);
        long ugly=1;
        for(int i=0;i<n;i++){
            ugly=pq.poll();
            for(int prime:primes){
                long next = ugly*prime;
                if(!set.contains(next)){
                    set.add(next);
                    pq.offer(next);
                }
            }
        }
        return (int)ugly;
    }
}