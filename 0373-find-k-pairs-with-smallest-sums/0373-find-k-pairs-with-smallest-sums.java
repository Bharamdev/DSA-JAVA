class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
            (a,b) -> (a.get(0)+a.get(1)) - (b.get(0)+b.get(1))
        );
        for(int i=0;i< Math.min(nums1.length, k);i++){
            pq.offer(Arrays.asList(nums1[i], nums2[0], 0));
        }
        while(k-- > 0 && !pq.isEmpty()){
            List<Integer> curr = pq.poll();
            res.add(Arrays.asList(curr.get(0), curr.get(1)));
            int idx = curr.get(2);
            if(idx+1 < nums2.length){
                pq.offer(Arrays.asList(curr.get(0), nums2[idx+1], idx+1));
            }
        }
        return res;
    }
}