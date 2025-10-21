class Solution {
    class pair{
        int freq;
        int num;
        pair(int freq, int num){
            this.freq = freq;
            this.num = num;
        }
    }
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Code here
        PriorityQueue<pair> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.freq==b.freq) return a.num-b.num;
                return a.freq-b.freq;
            }
        );
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: arr) map.put(num, map.getOrDefault(num,0)+1);
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.offer(new pair (entry.getValue(),entry.getKey()));
            if(pq.size()>k) pq.poll();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().num);
        }
        Collections.reverse(ans);
        return ans;
    }
}
