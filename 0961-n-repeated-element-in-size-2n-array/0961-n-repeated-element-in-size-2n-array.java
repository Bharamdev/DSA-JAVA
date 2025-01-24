class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] arr = new int[1000];
        for(int i=0; i<nums.length; i++){
            arr[nums[i]]++;
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]>1) return i;
        }
        return -1;
    }
}