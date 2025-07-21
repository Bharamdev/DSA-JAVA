class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum=0;
        for(int num: nums){
            sum+=num;
            pq.offer((double)num);
        }
        int cnt=0;
        double target=sum/2;
        while(sum>target){
            double max= pq.poll();
            double half = max/2;
            sum-= half;
            pq.offer(half);
            cnt++;
        }
        return cnt;
    }
}