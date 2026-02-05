class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            int idx = (i + nums[i]) % n;
            if(nums[i]<0) idx+=n;
            result[i]=nums[idx%n];
        }
        return result;
    }
}