class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int a = help1(nums,k);
        int b = help2(nums,k-1);
        return a-b;
    }
    public int help1(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        int r=0,l=0,cnt=0,ans=0;
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0) map.remove(nums[l]);
                l++;
            }
            ans+=(r-l+1);
            r++;
        }
        return ans;
    }
     public int help2(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        int r=0,l=0,cnt=0,ans=0;
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0) map.remove(nums[l]);
                l++;
            }
            ans+=(r-l+1);
            r++;
        }
        return ans;
    }
}