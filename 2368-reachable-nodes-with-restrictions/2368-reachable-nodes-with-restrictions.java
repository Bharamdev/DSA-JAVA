class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] arr: edges){
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        HashSet<Integer> set = new HashSet<>();
        for(int i: restricted) set.add(i);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0]=true;
        int cnt=0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            for(int it: adj.get(node)){
                if(!vis[it] && !set.contains(it)){
                    q.offer(it);
                    vis[it]=true;
                }
            }
        }
        return cnt;
    }
}