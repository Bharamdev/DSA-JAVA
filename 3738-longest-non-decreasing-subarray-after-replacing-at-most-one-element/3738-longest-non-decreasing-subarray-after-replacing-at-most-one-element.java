class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1])
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        }
        int ans = 1;
        // Case 1: No replacement
        for (int i = 0; i < n; i++) ans = Math.max(ans, left[i]);
        // Case 2: Replace one element 
        for (int i = 0; i < n; i++) {
            int best=1;
            if(i>0) best = Math.max(best, left[i-1]+1);
            if(i<n-1) best = Math.max(best, 1+right[i+1]);
            if(i>0 && i<n-1 && nums[i-1] <= nums[i+1]){
                best = Math.max(best, left[i-1]+right[i+1]+1);
            }
            ans = Math.max(ans,best);
        }

        return ans;
    }
}