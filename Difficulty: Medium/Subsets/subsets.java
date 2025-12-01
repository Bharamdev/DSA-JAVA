class Solution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        generate(0, arr, list);
        return ans;
    }
    void generate(int i, int[] arr , ArrayList<Integer> list){
        if(i >= arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        // Take
        list.add(arr[i]);
        generate(i+1, arr, list);
        // Not take
        list.remove(list.size()-1);
        generate(i+1, arr ,list);
    }
}