class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subSet(0, nums, ds, ans);
        return ans;
    }

      public static void subSet(int index, int[] arr, 
    ArrayList<Integer> ds, List<List<Integer>> ans ){
        ans.add(new ArrayList<>(ds));
       
        for(int i=index; i<arr.length; i++){
            // if(i>index && arr[i]==arr[i-1]) continue;
            //  if(index==arr.length) break;
            ds.add(arr[i]);
            subSet(i+1, arr, ds, ans);
            ds.remove(ds.size()-1);
            // subSet(i+1, arr, ds, ans);

        }
    }

}