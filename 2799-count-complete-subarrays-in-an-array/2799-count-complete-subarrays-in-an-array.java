class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i: nums) set.add(i);
        int k=set.size();
        int r=0,l=0;
        int ans=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()==k){
                ans+= n-r;
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])<1) map.remove(nums[l]);
                l++;
            }
            r++;
        }
        return ans;
    }
}