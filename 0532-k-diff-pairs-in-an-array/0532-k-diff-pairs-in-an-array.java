class Solution {
    public int findPairs(int[] nums, int k) {
        int cnt=0;
        int n=nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(int key : map.keySet()){
            if(k==0){
                if(map.get(key)>1) cnt++;
            }
            else{
                if(map.containsKey(key+k)) cnt++;
            }
        }
        return cnt;
    }
}