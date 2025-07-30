class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(a.length() != b.length()) return a.length()-b.length();
            else return a.compareTo(b);
        });
        for(String str : nums){
            pq.offer(str);
            if(pq.size()>k) pq.poll();
        }
        return pq.poll();
    }
}