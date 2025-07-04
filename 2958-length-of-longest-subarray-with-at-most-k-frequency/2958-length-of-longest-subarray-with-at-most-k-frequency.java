class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int n=nums.length;
        int r=0,l=0;
        int len=0;
        while(r<n){
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            while(map.get(nums[r])>k){
                map.put(nums[l], map.get(nums[l])-1);
                l++;
            }
            len = Math.max(len,r-l+1);
            r++;
        }
        return len;
    }
}