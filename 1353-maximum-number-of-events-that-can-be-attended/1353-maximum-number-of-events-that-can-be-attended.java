class Solution {
    public int maxEvents(int[][] events) {
        int n=events.length,day=0,ans=0;
        Arrays.sort(events,(a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int i=0;
        while(!pq.isEmpty() || i<n){
            if(pq.isEmpty()) day = events[i][0];
            while(i<n && events[i][0]<=day){
                pq.offer(events[i][1]);
                i++;
            }
            pq.poll();
            day++;
            ans++;
            while(!pq.isEmpty() && pq.peek() < day) pq.poll();
        }
        return ans;
    }
}