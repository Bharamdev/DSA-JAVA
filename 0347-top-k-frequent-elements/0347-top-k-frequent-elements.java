class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int num : map.keySet()){
            pq.offer(num);
            if(pq.size()>k) pq.poll();
        }
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            arr[i]=pq.poll();
        }
        return arr;
    }
}