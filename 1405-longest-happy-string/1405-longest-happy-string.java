class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder s = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[0]-x[0]);
        if(a>0) pq.offer(new int[]{a,'a'});
        if(b>0) pq.offer(new int[]{b,'b'});
        if(c>0) pq.offer(new int[]{c,'c'});
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            int len = s.length();
            if(len>=2 && s.charAt(len-1)==first[1] && s.charAt(len-2)==first[1]){
                if(pq.isEmpty()) break;
                int[] second = pq.poll();
                s.append((char)second[1]);
                if(--second[0]>0) pq.offer(second);
                pq.offer(first);
            }
            else{
                s.append((char)first[1]);
                if(--first[0]>0) pq.offer(first);
            }
        }
        return s.toString();
    }
}