class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums) map.put(num, map.getOrDefault(num,0)+1);
        int cnt=0;
        for( int value: map.values()){
            if(value==1) return -1;
            cnt+= (value+2)/3;
        }
        return cnt;
    }
}