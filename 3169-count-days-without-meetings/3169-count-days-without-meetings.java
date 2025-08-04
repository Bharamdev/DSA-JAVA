class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);
        int cnt=0;
        int start = meetings[0][0];
        int end = meetings[0][1];
        if(start!=1) cnt+=start-1;
        for(int i=0;i<meetings.length;i++){
            if(meetings[i][0]<=end){
                end = Math.max(end,meetings[i][1]);
            }
            else{
                cnt+=meetings[i][0]-end-1;
                end=meetings[i][1];
                start = meetings[i][0];
            }
        }
        cnt+=days-end;
        return cnt;
    }
}