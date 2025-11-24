class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>();
        int remain=0;
        for(int num: nums){
            remain = (remain*2 + num)%5;
            ans.add(remain==0);
        }
        return ans;
    }
}