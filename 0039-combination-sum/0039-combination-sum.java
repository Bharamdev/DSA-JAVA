class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        findAns(0, candidates,target, arr, ans);
        return ans;
        
    }
    public static void  findAns(int index,int[] candidates,int target, 
    ArrayList<Integer> arr, List<List<Integer>> ans){

        
        if (index == candidates.length){
            if(target==0){
            ans.add(new ArrayList<>(arr));
        }
            return;
        }

        if(candidates[index]<=target){
            arr.add(candidates[index]);
            findAns(index, candidates, target-candidates[index], arr, ans);
             arr.remove(arr.size()-1);
        }
        findAns(index+1,candidates,  target, arr, ans);
       

    }
}