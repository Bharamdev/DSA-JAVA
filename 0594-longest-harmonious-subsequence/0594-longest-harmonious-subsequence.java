class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int i: nums) map.put(i,map.getOrDefault(i,0)+1);
        if(map.size()<2) return 0;
        int len=0,ans=0;
        List<Integer> keys = new ArrayList<>(map.keySet());
        for(int i=1;i<map.size();i++){
            int curr = keys.get(i);
            int prev = keys.get(i-1);
            if(curr-prev==1){
                len = map.get(curr) + map.get(prev);
                ans = Math.max(ans,len);
            }
        }
        return ans;
    }
}