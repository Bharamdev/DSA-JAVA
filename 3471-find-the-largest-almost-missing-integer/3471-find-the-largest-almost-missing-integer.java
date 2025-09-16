class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<=n-k;i++){
            for(int j=i;j<i+k;j++){
                int num=nums[j];
                map.putIfAbsent(num, new HashSet<>());
                map.get(num).add(i);
            }
        }
        int ans=-1;
        for(int key: map.keySet()){
            if(map.get(key).size() == 1) ans = Math.max(ans, key);
        }
        return ans;
    }
}