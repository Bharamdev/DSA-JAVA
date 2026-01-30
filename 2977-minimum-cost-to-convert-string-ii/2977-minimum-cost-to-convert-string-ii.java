class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        long INF = (long)1e18;
        Set<String> set = new HashSet<>();
        for(String og: original) set.add(og);
        for(String  cg: changed) set.add(cg);
        List<String> list = new ArrayList<>(set);
        int m = list.size();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(list.get(i),i);
        }
        long[][] dist = new long[m][m];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],INF);
            dist[i][i]=0;
        }
        for(int i=0;i<original.length;i++){
            int u = map.get(original[i]);
            int v = map.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        for(int k=0;k<m;k++){
            for(int i=0;i<m;i++){
                if(dist[i][k]==INF) continue;
                for(int j=0;j<m;j++){
                    if(dist[k][j]==INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        long[] dp = new long[n+1];
        Arrays.fill(dp, INF);
        dp[0]=0;
        for(int i=0;i<n;i++){
            if(dp[i]==INF) continue;
            if(source.charAt(i)==target.charAt(i)) dp[i+1] = Math.min(dp[i+1],dp[i]);
            for(int len=1; i+len<=n; len++){
                String ssub = source.substring(i, i+len);
                String tsub = target.substring(i, i+len);
                Integer u = map.get(ssub);
                Integer v = map.get(tsub);
                if(u!=null && v!=null && dist[u][v]!=INF){
                    dp[i+len] = Math.min(dp[i+len], dp[i]+dist[u][v]);
                }
            }
        }
        return dp[n]==INF ? -1 : dp[n];
    }
}