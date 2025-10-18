class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int e = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
        }
        ArrayList<Integer> topo = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            for(int it: adj.get(i)) inDegree[it]++;
        }
        for(int i=0;i<V;i++){
            if(inDegree[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int it: adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0) q.offer(it);
            }
        }
        return topo;
    }
}