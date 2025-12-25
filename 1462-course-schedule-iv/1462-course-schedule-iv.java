class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for(int[] p: prerequisites){
            adj.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }
        boolean[][] ispre = new boolean[numCourses][numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v: adj.get(u)){
                ispre[u][v]=true;
                for(int x=0;x<numCourses;x++){
                    if(ispre[x][u]) ispre[x][v]=true;
                }
                indegree[v]--;
                if(indegree[v]==0) q.offer(v);
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] a: queries){
            res.add(ispre[a[0]][a[1]]);
        }
        return res;
    }
}