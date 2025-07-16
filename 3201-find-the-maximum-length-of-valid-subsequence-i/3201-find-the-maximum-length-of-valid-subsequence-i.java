class Solution {
    public int maximumLength(int[] nums) {
        int odd=0,even=0;
        for(int num:nums){
            if(num%2==0) even++;
            else odd++;
        }
        int sameParity = Math.max(odd,even);
        int alternate=1;
        int expected = 1-(nums[0]%2);
        for(int i=1;i<nums.length;i++){
            if((nums[i]%2)==expected){
                alternate++;
                expected = 1-expected;  
            }
        }
        return Math.max(sameParity,alternate);
    }
}