class Solution {
    int[] buckets;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        buckets = new int[k];
        for(int num: nums) sum+=num;
        if(sum%k!=0) return false;
        Arrays.sort(nums);
        if(nums[nums.length-1] > sum/k) return false; 
        return backtrack(nums.length-1, nums, sum/k);
    }
    boolean backtrack(int idx, int[] nums, int target){
        if(idx<0) return true;
        for(int i=0;i<buckets.length;i++){
            if(buckets[i]+nums[idx] <= target){
                buckets[i]+=nums[idx];
                if(backtrack(idx-1, nums, target)) return true;
                buckets[i]-=nums[idx];
            }
            // Avoid repeating same state on empty Buckets
            if(buckets[i]==0) break;
        }
        return false;
    }
}