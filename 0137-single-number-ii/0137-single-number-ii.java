class Solution {
    public int singleNumber(int[] nums) {
        long one=0;
        long two=0;
        for(int num: nums){
            one = (one^num) & ~two;
            two = (two^num) & ~one;
        }
        return (int)one;
    }
}