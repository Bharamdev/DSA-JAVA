class Solution {
    public long maxProduct(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        for(int num: nums){
            if(Math.abs(num)>max1){
                max2=max1;
                max1=Math.abs(num);
            }
            else if(Math.abs(num)>max2) {
                max2=Math.abs(num);
            }
        }
        long mul= max1*max2*100000;
        return mul;
    }
}