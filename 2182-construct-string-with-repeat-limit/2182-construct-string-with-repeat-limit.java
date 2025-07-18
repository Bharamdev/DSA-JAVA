class Solution {
    class pair{
        char ch;
        int freq;
        pair(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character,Integer> map  = new HashMap<>();
        for(char ch: s.toCharArray()) map.put(ch,map.getOrDefault(ch,0)+1);
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> Character.compare(b.ch,a.ch));
        for(char ch: map.keySet()) pq.add(new pair(ch,map.get(ch)));
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int freq = curr.freq;
            char ch = curr.ch;
            int min = Math.min(freq,repeatLimit);
            for(int i=0;i<min;i++) str.append(ch);
            freq = freq-min;
            if(freq>0){
                if(pq.isEmpty()) break;
                pair next = pq.poll();
                str.append(next.ch);
                if(next.freq>0)pq.offer(new pair(next.ch,next.freq-1));
                pq.offer(new pair(ch,freq));
            }
        }
        return str.toString();
    }
}