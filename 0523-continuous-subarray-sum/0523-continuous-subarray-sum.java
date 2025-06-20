class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int presum=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            presum+=nums[i];
            int rem = presum%k;
            if(map.containsKey(rem)){
                if(i-map.get(rem)>=2) return true;
            }
            else map.put(rem,i);
            
        }
        return false;
    }
}