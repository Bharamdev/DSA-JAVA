class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = maxGap(hBars);
        int maxV = maxGap(vBars);
        int side = Math.min(maxH, maxV);
        return side*side;
    }
    int maxGap(int[] bars){
        Arrays.sort(bars);
        int max=1, cnt=1;
        for(int i=1;i<bars.length;i++){
            if(bars[i] == bars[i-1]+1) cnt++;
            else cnt=1;
            max = Math.max(max, cnt);
        }
        return max+1;    // +1 bcoz k removed bars create k+1 gaps 
    }
}