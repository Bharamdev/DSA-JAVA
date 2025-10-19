class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
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
        int[] topo = new int[n];
        int idx=0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[idx++] = node;
            for(int it: adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0) q.offer(it);
            }
        }
        if(idx!=n) return new int[]{};
        return topo;
    }
}