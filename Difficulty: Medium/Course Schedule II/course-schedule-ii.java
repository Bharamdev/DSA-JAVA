class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] arr: prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }
        int[] inDegree = new int[n];
        for(int i=0;i<n;i++){
            for(int it: adj.get(i)) inDegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0) q.offer(i);
        }
        ArrayList<Integer> topo = new ArrayList<>();
        int idx=0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            idx++;
            for(int it: adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0) q.offer(it);
            }
        }
        if(idx!=n) return new ArrayList<>();
        return topo;
    }
}