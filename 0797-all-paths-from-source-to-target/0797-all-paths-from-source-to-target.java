class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0,list,graph);
        return ans;
    }
    void dfs(int node, List<Integer> list, int[][]graph){
        list.add(node);
        if(node == graph.length-1) {
            ans.add(new ArrayList<>(list));
        }
        else{
            for(int i: graph[node]){
            dfs(i, list,graph);
            }
        }
        list.remove(list.size()-1);
    }
}