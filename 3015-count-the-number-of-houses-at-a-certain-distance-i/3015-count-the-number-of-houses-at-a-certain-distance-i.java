class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[] res = new int[n];
        x--;
        y--;
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++){
            if(i==j) continue;
            int direct = Math.abs(i-j);
            int viaXY = Math.abs(i-x) + 1 + Math.abs(j-y);
            int viaYX = Math.abs(i-y) + 1 + Math.abs(j-x);
            int dist = Math.min(direct, Math.min(viaXY, viaYX));
            res[dist-1]++;
        }
        return res;
    }
}