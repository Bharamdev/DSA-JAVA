class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
        }
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            for(int it: adj.get(i)) inDegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0) q.offer(i);
        }
        int cnt=0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            for(int it: adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0) q.offer(it);
            }
        }
        return V!=cnt;
    }
}