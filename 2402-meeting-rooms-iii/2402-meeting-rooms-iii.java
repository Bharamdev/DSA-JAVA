class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);
        // Free rooms -> smallest room first
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for(int i=0;i<n;i++) freeRooms.offer(i);
        // Busy rooms: [endTime, roomNo.]
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a,b) -> {
            if(a[0]==b[0]) return Long.compare(a[1],b[1]);
            return Long.compare(a[0],b[0]);
        });
        int[] count = new int[n];
        for(int[] meeting: meetings){
            long start = meeting[0];
            long end = meeting[1];
            long time = end-start;
            while(!busyRooms.isEmpty() && busyRooms.peek()[0]<=start){
                freeRooms.offer( (int)busyRooms.poll()[1]);
            }
            if(!freeRooms.isEmpty()){
                int room = freeRooms.poll();
                busyRooms.offer(new long[]{end, room});
                count[room]++;
            }
            else{
                long[] busy = busyRooms.poll();
                long newEnd = busy[0]+time;
                busyRooms.offer(new long[]{newEnd, busy[1]});
                count[(int)busy[1]]++;
            }
        }
        int ans = 0;
        for(int i=1;i<n;i++){
            if(count[i] > count[ans]) ans=i;
        }
        return ans;
    }
}