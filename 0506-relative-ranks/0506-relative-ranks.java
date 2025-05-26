class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        String[] str = new String[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for(int i=0;i<n;i++){
            pq.offer(new int[]{score[i],i});
        }
        int rank=1;
        while(!pq.isEmpty()){
            int[] max = pq.poll();
            int index = max[1];
            if(rank==1) str[index]="Gold Medal";
            else if(rank==2) str[index]="Silver Medal";
            else if(rank==3) str[index]="Bronze Medal";
            else str[index]= String.valueOf(rank);
            rank++;
        }
        return str;
    }
}