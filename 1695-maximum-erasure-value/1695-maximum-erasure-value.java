class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n=nums.length,r=0,l=0;
        int sum=0,ans=0;
        while(r<n){
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            sum+=nums[r];
            while(map.get(nums[r])>1){
                map.put(nums[l],map.get(nums[l])-1);
                sum-=nums[l];
                l++;
            }
            ans = Math.max(ans,sum);
            r++;
        }
        return ans;
    }
}