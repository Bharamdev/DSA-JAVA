class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> arr = new ArrayList<>();
        backtrack(1,k,n,arr);
        return res; 
    }
    void backtrack(int start, int k, int remaining, List<Integer> arr){
        if(arr.size()==k){
            if(remaining==0) res.add(new ArrayList<>(arr));
            return;
        }
        for(int i=start;i<=9;i++){
            if(i>remaining) break;
            arr.add(i);
            backtrack(i+1, k, remaining-i, arr);
            arr.remove(arr.size()-1);
        }
    }
}