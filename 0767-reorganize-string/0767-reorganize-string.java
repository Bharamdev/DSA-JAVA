class pair{
    char ch;
    int freq;
    pair(char ch, int freq){
        this.ch = ch;
        this.freq=freq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)-> b.freq-a.freq);
        for(Map.Entry<Character,Integer> m: map.entrySet()){
            pq.offer(new pair(m.getKey(),m.getValue()));
        }
        StringBuilder str = new StringBuilder();
        while(pq.size()>1){
            pair curr = pq.poll();
            str.append(curr.ch);
            curr.freq--;
            pair next = pq.poll();
            str.append(next.ch);
            next.freq--;
            if(curr.freq>0) pq.offer(curr);
            if(next.freq>0) pq.offer(next);
        }
        if(!pq.isEmpty()){
            pair last = pq.poll();
            if(last.freq>1) return "";
            str.append(last.ch);
        }
        return str.toString();
    }
}