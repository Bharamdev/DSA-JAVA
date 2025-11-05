class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int ans = Integer.MAX_VALUE;
        for(int s=0;s<n;s++){
            Queue<Integer> q = new LinkedList<>();
            int[] dist = new int[n];
            Arrays.fill(dist, -1);
            int[] parent = new int[n];
            Arrays.fill(parent, -1);
            q.offer(s);
            dist[s]=0;
            while(!q.isEmpty()){
                int node = q.poll();
                for(int it: adj.get(node)){
                    if(dist[it]==-1){
                        dist[it]=dist[node]+1;
                        parent[it]=node;
                        q.offer(it);
                    }
                    else if(parent[node]!=it){
                        ans = Math.min(ans, dist[node]+dist[it]+1);
                        if(ans==3) return 3;
                    }
                }
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}