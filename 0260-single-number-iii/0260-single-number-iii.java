class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num: nums) xor^=num;
        int diff = xor & (-xor);    // Get rightmost set bit 
        int a=0,b=0;
        // Split numbers into two XOR groups
        for(int num: nums){
            if((num&diff)==0) a^=num;
            else b^=num;
        }
        return new int[]{a,b};
    }
}