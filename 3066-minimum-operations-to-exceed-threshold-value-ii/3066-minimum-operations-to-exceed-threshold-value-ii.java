class Solution {
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num:nums) pq.offer((long)num);
        int cnt=0;
        while(pq.size()>=2 && pq.peek()<k){
            long x = pq.poll();
            long y=pq.poll();
            long updated = Math.min(x,y)*2 + Math.max(x,y);
            pq.offer(updated);
            cnt++; 
        }
        return cnt;
    }
}