class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        FindList(0, candidates, target, ds, ans);
        return ans;
    }

    public static void FindList(int index, int[] arr,  int target,
    ArrayList<Integer> ds, List<List<Integer>> ans ){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=index; i<arr.length; i++){
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>target) break;
            ds.add(arr[i]);
            FindList(i+1, arr, target-arr[i], ds, ans);
            ds.remove(ds.size()-1);
            // FindList(index+1, arr, target,  ds, ans);
        }
    }

}