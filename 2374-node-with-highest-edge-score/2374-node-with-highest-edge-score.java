class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] score = new long[n];
        for(int i=0;i<n;i++){
            score[edges[i]] += i;
        }
        long max=0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(score[i]>max){
                max=score[i];
                ans=i;
            }
        }
        return ans;
    }
}