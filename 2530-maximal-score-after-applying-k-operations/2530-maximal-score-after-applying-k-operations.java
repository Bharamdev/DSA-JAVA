class Solution {
    public long maxKelements(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum=0;
        for(int num: nums){
             pq.offer(num);
        }
        while(k-->0){
            int top = (pq.poll());
            sum+=(long)top;
            pq.offer((top+2)/3);
        }
        return sum;
    }
}