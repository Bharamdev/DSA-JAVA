class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n=dist.length;
        float[] ans = new float[n];
        float div;
        int cnt=0;
        for(int i=0; i<n; i++){
            ans[i]= (float)dist[i]/speed[i];
        }
        Arrays.sort(ans);
        for(int i=0; i<n; i++){
            div = (-1*i) + ans[i];
            if(div<=0) break;
            cnt++;
        }
        return cnt;
    }
}