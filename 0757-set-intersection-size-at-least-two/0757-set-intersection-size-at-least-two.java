class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a,b ) -> {
            if(a[1]==b[1]) return b[0]-a[0];
            return a[1]-b[1];
        });
        int a=-1, b=-1;
        int cnt=0;
        for(int[] in: intervals){
            int start=in[0], end=in[1];
            boolean containsA = (a>=start && b<=end);
            boolean containsB = (b>=start && b<=end);
            if(containsA && containsB) continue;
            else if(containsB){
                a=b;
                b=end;
                cnt++;
            }
            else{
                a=end-1;
                b=end;
                cnt+=2;
            }
        }
        return cnt;
    }
}