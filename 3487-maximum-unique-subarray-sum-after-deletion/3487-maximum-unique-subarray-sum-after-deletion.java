class Solution {
    public int maxSum(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // for(int num: nums){
        //     set.add(num);
        // }
        // int pos=0,neg=Integer.MIN_VALUE;
        // for(int num: set) {
        //     if(num>0) pos+=num;
        //     else neg= Math.max(neg,num);
        // }

        // return pos==0 ? neg : pos;

        // Optimize
        Arrays.sort(nums);
        int n=nums.length;
        int prev = nums[n-1];
        int sum=nums[n-1];
        for(int i=n-2;i>=0;i--){
            int num = nums[i];
            if(num<=0) return sum;
            else if(num!=prev) sum+=num;
            prev=num;
        }
        return sum;
    }
}