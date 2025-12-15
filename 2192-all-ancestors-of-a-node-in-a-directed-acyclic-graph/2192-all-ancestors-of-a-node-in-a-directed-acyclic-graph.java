    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            List<List<Integer>> revadj = new ArrayList<>();
            for(int i=0;i<n;i++) {
                res.add(new ArrayList<>());
                revadj.add(new ArrayList<>());
            }
            for(int[] e: edges) revadj.get(e[1]).add(e[0]);
            for(int i=0;i<n;i++){
                boolean[] vis = new boolean[n];
                dfs(i,i,revadj,vis);
            }
            for(int i=0;i<n;i++) Collections.sort(res.get(i));
            return res;
        }
        void dfs(int start, int node, List<List<Integer>> revadj, boolean[] vis){
            vis[node]=true;
            for(int it: revadj.get(node)){
                if(!vis[it]){
                    res.get(start).add(it);
                    dfs(start,it,revadj,vis);
                }
            }
        }
    }