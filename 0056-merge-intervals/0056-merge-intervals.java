class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1) return intervals;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int[] arr = intervals[0];
        for(int[] interval : intervals){
            if(interval[0]<=arr[1]){
                arr[1]= Math.max(arr[1],interval[1]);
            }
            else{
                ans.add(arr);
                arr=interval;
            }
        }
        ans.add(arr);
        return ans.toArray(new int[ans.size()][]);
    }
}