class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int v = numCourses;
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
        for(int[] arr: prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }
        int[] inDegree = new int[v];
        for(int i=0;i<v;i++){
            for(int it: adj.get(i)) inDegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inDegree[i]==0) q.offer(i);
        }
        int cnt=0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            for(int it: adj.get(node)){
                inDegree[it]--;
                if(inDegree[node]==0) q.offer(it);
            }
        }
        return v==cnt;
    }
}