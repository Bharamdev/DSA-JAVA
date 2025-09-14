class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(nums);
        arr.add(nums[nums.length-1]);
        for(int i=nums.length-2;i>=0 && arr.size()<k; i--){
            if(nums[i]!=nums[i+1]){
                arr.add(nums[i]);
            }
        }
        int[] ans = new int[arr.size()];
        for(int i=0;i<arr.size();i++) ans[i]=arr.get(i);
        return ans;
    }
}