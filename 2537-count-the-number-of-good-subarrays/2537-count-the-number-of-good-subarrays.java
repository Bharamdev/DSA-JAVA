class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int cnt=0, res=0;
        int n=nums.length,l=0;
        for(int r=0;r<n;r++){
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            if(map.get(nums[r])>1) cnt+=map.get(nums[r])-1;
            while(cnt>=k){
                if(map.get(nums[l])>1) cnt-=map.get(nums[l])-1;
                map.put(nums[l],map.get(nums[l])-1);
                l++;
                res+=n-r;
            }
        }
        return res;
    }
}