class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        long maxSum=0;
        long sum=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            map.put(num, map.getOrDefault(num,0)+1);
            while(map.getOrDefault(num,0)>1){
                map.put(nums[j], map.get(nums[j])-1);
                if(map.get(nums[j])==0) map.remove(nums[j]);
                sum-=nums[j++];
            }
            sum+=num;
            if(i-j+1>k){
                sum-=nums[j];
                map.put(nums[j], map.get(nums[j])-1);
                if(map.get(nums[j])==0) map.remove(nums[j++]);
            }
            if(i-j+1==k) maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}