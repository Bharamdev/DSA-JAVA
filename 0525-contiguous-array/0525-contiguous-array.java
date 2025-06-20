class Solution {
    public int findMaxLength(int[] nums) {
        int sum=0,len=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+= nums[i]==0 ? -1 : 1;
            if(map.containsKey(sum)){
                len = Math.max(len, i-map.get(sum));
            }
            else map.put(sum,i);
        }
        return len;
    }
}