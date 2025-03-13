class Solution {
    public int maximumCount(int[] nums) {
        int pos=0, neg=0;
        for(int num: nums){
            if(num<0) neg++;
            else if(num>0) pos++;
        }
        return Math.max(pos,neg);
    }
}