class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> Integer.compare(a[1],b[1]));
        int cnt=1;
        int end = pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>end){
                cnt++;
                end = pairs[i][1];
            }
        }
        return cnt;
    }
}