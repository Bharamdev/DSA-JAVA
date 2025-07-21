class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum=0;
        for(int num: piles){
             pq.offer(num);
             sum+=num;
        }
        while(k-->0){
            int full = (pq.poll());
            int half = full/2;
            sum-=half;
            pq.offer(full-half);
        }
        return sum;
    }
}