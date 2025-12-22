class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            if(edges[i]!=-1) indegree[edges[i]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            int next = edges[node];
            if(next!=-1){
                indegree[next]--;
                if(indegree[next]==0) q.offer(next);
            }
        }
        int ans=-1;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(indegree[i]>0 && !vis[i]){
                int curr=i;
                int cnt=0;
                while(!vis[curr]){
                    vis[curr]=true;
                    curr=edges[curr];
                    cnt++;
                }
                ans = Math.max(ans,cnt);
            }
        }
        return ans;
    }
}