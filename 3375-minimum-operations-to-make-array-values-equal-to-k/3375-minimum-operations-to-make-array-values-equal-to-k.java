class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int cnt=0;
        for(int num: nums){
            set.add(num);
        }
        for(int num: set){
            if(num>k) cnt++;
            else if(num<k) return -1; 
        }
        return cnt;
    }
}