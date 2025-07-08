class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n: arr) map.put(n,map.getOrDefault(n,0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n=arr.length;
        for(int val: map.values()){
            pq.offer(val);
        }
        int cnt=0, remove=0;
        while(remove<n/2){
            remove+=pq.poll();
            cnt++;
        }
        return cnt;
    }
}