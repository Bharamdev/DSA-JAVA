class Solution {
    public int minSubarray(int[] nums, int p) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum=0;
        for(int num: nums) sum+=num;
        int need = (int)(sum%p);
        if(need==0) return 0;
        long pre=0;
        int ans=nums.length;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            pre = (pre+nums[i])%p;
            int target = (int)((pre - need + p)%p);
            if(map.containsKey(target)) ans = Math.min(ans, i-map.get(target));
            map.put((int)pre, i);
        }
        return ans==nums.length ? -1 : ans;
    }
}