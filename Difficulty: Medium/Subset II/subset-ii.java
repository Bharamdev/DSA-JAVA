class Solution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findSubsets(int[] arr) {
        // code here
        Arrays.sort(arr);  // sort to handle duplicates
        
        ArrayList<Integer> list = new ArrayList<>();
        generate(0, arr, list);
        return ans;
    }
    void generate(int index, int[] arr, ArrayList<Integer> list) {
        ans.add(new ArrayList<>(list));

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue; // skip duplicates

            list.add(arr[i]);
            generate(i + 1, arr, list);
            list.remove(list.size() - 1);
        }
    }
}


