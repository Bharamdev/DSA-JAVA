class Solution {
    public int minimumOperations(int[] nums) {
        int cnt=0;
        for(int num: nums){
            if(num%3!=0) cnt++;
        }
        return cnt;
    }
}