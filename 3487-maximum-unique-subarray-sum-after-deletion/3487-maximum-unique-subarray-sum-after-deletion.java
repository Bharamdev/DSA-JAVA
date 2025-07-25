class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int pos=0,neg=Integer.MIN_VALUE;
        for(int num: set) {
            if(num>0) pos+=num;
            else neg= Math.max(neg,num);
        }

        return pos==0 ? neg : pos;
    }
}