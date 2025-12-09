class Solution {
    public int specialTriplets(int[] nums) {
        long cnt=0;
        int mod = 1000000007;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums) map.put(num, map.getOrDefault(num,0)+1);
        Map<Integer,Integer> prefix = new HashMap<>();
        prefix.put(nums[0], 1);
        map.put(nums[0], map.get(nums[0])-1);
        for(int i=1;i<nums.length-1;i++){
            int num=nums[i];
            map.put(num,map.get(num)-1);
            int left = map.getOrDefault(num*2,0);
            int right = prefix.getOrDefault(num*2,0);
            long combinations = ((long)left * right)%mod;
            cnt= (cnt+combinations)%mod; 
            prefix.put(num, prefix.getOrDefault(num,0)+1);
        } 
        return (int)(cnt%mod);
    }
}