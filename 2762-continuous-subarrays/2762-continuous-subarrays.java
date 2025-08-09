class Solution {
    public long continuousSubarrays(int[] nums) {
        long cnt=0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int l=0;
        for(int r=0;r<nums.length;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.lastKey()-map.firstKey() > 2){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])<=0) map.remove(nums[l]);
                l++;
            }
            cnt+=(r-l+1);
        }
        return cnt;
    }
}