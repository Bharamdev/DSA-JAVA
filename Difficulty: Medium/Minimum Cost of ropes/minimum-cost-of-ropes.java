class Solution {
    public static int minCost(int[] arr) {
        // code here
        long cost=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a: arr) pq.offer(a);
        while(pq.size()>1){
            int sum = pq.poll() + pq.poll();
            cost+=sum;
            pq.offer(sum);
        }
        return (int)cost;
    }
}