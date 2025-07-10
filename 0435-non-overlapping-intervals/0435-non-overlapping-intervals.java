class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Arrays.sort(intervals, (a,b) ->{
        // if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
        // else return Integer.compare(a[1],b[1]);
        // });
        // int remove=0;
        // int n=intervals.length;
        // if(n==1) return 0;
        // int[] nonOverLapping = intervals[0];
        // for(int i=1;i<n;i++){
        //     if(nonOverLapping[1]>intervals[i][0]) {
        //         remove++;
        //         if(nonOverLapping[1]>intervals[i][1]) nonOverLapping=intervals[i];
        //     }
        //     else{
        //         nonOverLapping= intervals[i];
        //     }
        // }
        
        // return remove;

        // Sort intervals by end time (not start time)
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
         int remove=0;
        int n=intervals.length;
        int[] nonOverLapping = intervals[0];
        for(int i=1;i<n;i++){
            if(nonOverLapping[1]>intervals[i][0]) {
                remove++;
            }
            else{
                nonOverLapping= intervals[i];
            }
        }
        
        return remove;
    }
}