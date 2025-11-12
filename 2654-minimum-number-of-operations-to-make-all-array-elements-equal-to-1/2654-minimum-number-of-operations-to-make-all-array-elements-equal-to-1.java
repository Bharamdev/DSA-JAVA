class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones=0;
        // Already have ones
        for(int num: nums){
            if(num==1) ones++;
        }
        if(ones>0) return n-ones;
        // not possible
        int curr =  nums[0];
        for(int num: nums) curr = gcd(curr,num);
        if(curr>1) return -1;
        // Shortest subarray with gcd 1;
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            int currgcd = nums[i];
            for(int j=i+1;j<n;j++){
                currgcd = gcd(currgcd,nums[j]);
                if(currgcd==1){
                    minLen = Math.min(minLen, j-i+1);
                    break;
                }
            }
        }
        // we need minLen-1 operations to make one 1. then (n-1) more to spread it 
        return (minLen-1) + (n-1);
    }
    int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}