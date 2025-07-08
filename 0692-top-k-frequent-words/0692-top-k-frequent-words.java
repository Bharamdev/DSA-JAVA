class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++) map.put(words[i], map.getOrDefault(words[i],0)+1);
        PriorityQueue<Map.Entry<String,Integer>> pq= new PriorityQueue<>((a,b)->{
            if(!a.getValue().equals(b.getValue())) return b.getValue() - a.getValue(); 
            else return  a.getKey().compareTo(b.getKey());
        });
        for(Map.Entry<String,Integer> keySet: map.entrySet()){
            pq.offer(keySet);
        }
        List<String> res = new ArrayList<>();
        while(k-->0){
            String str = pq.poll().getKey();
            res.add(str);
        }
        return res;
    }
}