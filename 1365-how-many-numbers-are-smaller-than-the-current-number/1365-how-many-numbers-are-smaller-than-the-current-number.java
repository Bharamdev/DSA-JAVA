class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
       int cnt;
       int[] arr = new int[nums.length];
       int[] count = new int[101];
        // for(int i=0; i<nums.length; i++){
        //     cnt=0;
        //     for(int j=0; j<nums.length; j++){
        //         if(nums[i]>nums[j]){
        //             cnt++;
        //         }
        //     }
        //     arr[i]=cnt;
        // }
        // return arr;
        for(int i=0; i<nums.length; i++){
            count[nums[i]]++;
        }
        for(int i=1; i<101; i++){
            count[i] += count[i-1];
        }
        for(int i=0; i<nums.length; i++){
            arr[i] = nums[i]==0 ? 0 : count[nums[i]-1];
        }
        return arr;
    }
}