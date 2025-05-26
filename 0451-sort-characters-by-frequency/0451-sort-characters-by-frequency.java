class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()){
            char ch = pq.poll();
            int freq = map.get(ch);
            for(int i=0;i<freq;i++){
                str.append(ch);
            }
        }
        return str.toString();
    }
}