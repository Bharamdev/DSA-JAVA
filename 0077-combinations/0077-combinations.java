class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        fn(1,n,1,k,list);
        return ans;
    }
    void fn(int i, int n, int j, int  k, List<Integer> list){
        if(j>k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i>n) return;
        list.add(i);                       // Take
        fn(i+1, n, j+1, k, list);   
        list.remove(list.size()-1);        // Not Take
        fn(i+1, n, j, k, list);            
    }
}