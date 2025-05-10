class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int zero1=0,zero2=0;
        long sum1=0,sum2=0;
        for(int i: nums1){
            if(i==0) zero1++;
            sum1+=i;
        }
        for(int i: nums2){
            if(i==0) zero2++;
            sum2+=i;
        }
        long min1= sum1+zero1;
        long min2 = sum2+zero2;
        if(zero1==0 && zero2==0){
            return sum1==sum2 ? sum1 : -1;
        }
        else if(zero1==0){
            return min2<=sum1 ? sum1 : -1;
        }
        else if(zero2==0){
            return min1<=sum2 ? sum2 : -1;
        }
        return Math.max(min1,min2);
    }
}