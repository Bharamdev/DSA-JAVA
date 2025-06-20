class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int presum=0;
        Map<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            presum+=nums[i];
            int div = presum%k;
            if(div<0) div+=k;
            if(map.containsKey(div)) cnt+=map.get(div);
            map.put(div, map.getOrDefault(div,0)+1);
        }
        return cnt;
    }
}