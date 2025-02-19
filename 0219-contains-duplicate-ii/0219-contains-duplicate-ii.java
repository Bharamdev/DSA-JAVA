class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> arr = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(i>k) arr.remove(nums[i-k-1]);
            if(!arr.add(nums[i])) return true;
        }
        return false;
    }
}