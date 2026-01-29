class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];
        for(int i=0;i<26;i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i]=0;
        }
        int n = original.length;
        for(int i=0;i<n;i++){
            int u = original[i]-'a';
            int v = changed[i]-'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        long ans=0;
        for(int i=0;i<source.length();i++){
            int u = source.charAt(i)-'a';
            int v = target.charAt(i)-'a';
            if(dist[u][v]==Integer.MAX_VALUE) return -1;
            ans+=dist[u][v];
        }
        return ans;
    }
}