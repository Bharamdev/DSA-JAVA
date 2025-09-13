class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch: tasks) freq[ch-'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i : freq){
            if(i > 0) pq.offer(i);
        }
        // int[] = [RemainingTime, ReadyTime];
        Queue<int[]> q = new LinkedList<>();
        int time=0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int cnt = pq.poll()-1;
                if(cnt>0) q.offer(new int[]{cnt, time+n});
            }
            if(!q.isEmpty() && q.peek()[1]<=time){
                pq.offer(q.poll()[0]);
            }
        }
        return time;
    }
}