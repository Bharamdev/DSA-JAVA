class Solution {
    public int minimumOperations(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            // if(num>0) set.add(num);
            if(num>0) map.put(num, map.getOrDefault(num,0)+1);
        }
        // return set.size();
        return map.size();
    }
}