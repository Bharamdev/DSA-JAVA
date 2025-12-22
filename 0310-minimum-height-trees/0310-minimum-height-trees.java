class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] inDegree = new int[n];
        if(n==1) return Arrays.asList(0);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            inDegree[e[0]]++;
            inDegree[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==1) q.offer(i);
        }
        int remaining = n;
        while(remaining>2){
            int size = q.size();
            remaining-=size;
            for(int leaf=0; leaf<size; leaf++){
                int node = q.poll();
                for(int it: adj.get(node)){
                    inDegree[it]--;
                    if(inDegree[it]==1) q.offer(it);
                }
            }
        }
        return new ArrayList<>(q);
    }
}