class Solution {
    public int minRemoval(int intervals[][]) {
        // code here
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        int remove=0;
        int[] last = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(last[1] > intervals[i][0]) remove++;
            else last = intervals[i];
        }
        return remove;
    }
}
