class Solution {
    public List<Integer> intersection(int[][] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int[] num:nums){
            Arrays.sort(num);
            for(int j=0; j<num.length; j++){
                map.put(num[j], map.getOrDefault(num[j],0) + 1);
            }
        }
        for(int i=0; i<nums[0].length; i++){
            if(map.get(nums[0][i])==nums.length){
                ans.add(nums[0][i]);
            }
        }
        return ans;
    }
}