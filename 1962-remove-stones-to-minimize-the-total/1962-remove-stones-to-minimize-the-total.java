class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: piles) pq.offer(num);
        while(k-->0){
            int half = (pq.poll()+1)/2;
            pq.offer(half);
        }
        int sum=0;
        while(!pq.isEmpty()) sum+=pq.poll();
        return sum;
    }
}