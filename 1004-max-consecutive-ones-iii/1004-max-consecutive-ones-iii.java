class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero=0,max=0;
        int i=0,j=0;
        int n=nums.length;
        // Worst time complexicity 2n
        // while(j<n){
        //     if(nums[j]==0){
        //         zero++;
        //     }
        //     while(zero>k){
        //         if(nums[i]==0) zero--;
        //         i++;
        //     }
        //     if(zero<=k) max= Math.max(max,j-i+1);
        //     j++;
        // }
        while(j<n){
            if(nums[j]==0){
                zero++;
            }
            if(zero>k){
                if(nums[i]==0) zero--;
                i++;
            }
            if(zero<=k) max= Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}