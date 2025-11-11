// User function Template for Java
class disjoint{
    int[] parent;
    int[] rank;
    disjoint(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
    }
    int findparent(int node){
        if(parent[node]==node) return node;
        return parent[node] = findparent(parent[node]);
    }
    void unionRank(int u, int v){
        int pu = findparent(u);
        int pv = findparent(v);
        if(pu==pv) return;
        if(rank[pu]>rank[pv]) parent[pv]=pu;
        else if(rank[pu]<rank[pv]) parent[pu]=pv;
        else{
            parent[pv]=pu;
            rank[pu]++;
        }
    }
}
class Solution {
    static ArrayList<ArrayList<String>> accountsMerge(
        ArrayList<ArrayList<String>> accounts) {
        // code here
        int n = accounts.size();
        disjoint ds = new disjoint(n);
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String str = accounts.get(i).get(j);
                if(!map.containsKey(str)){
                    map.put(str,i);
                }
                else{
                    ds.unionRank(i,map.get(str));
                }
            }
        }
        ArrayList<ArrayList<String>> merge = new ArrayList<>();
        for(int i=0;i<n;i++) merge.add(new ArrayList<>());
        for(Map.Entry<String, Integer> it: map.entrySet()){
            String mail = it.getKey();
            int node = ds.findparent(it.getValue());
            merge.get(node).add(mail);
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
           if(merge.get(i).size()==0) continue;
           Collections.sort(merge.get(i));
           ArrayList<String> temp = new ArrayList<>();
           temp.add(accounts.get(i).get(0));
           for(String it: merge.get(i)) {
               temp.add(it);
           }
           ans.add(temp);
        }
        return ans;
    }
}
