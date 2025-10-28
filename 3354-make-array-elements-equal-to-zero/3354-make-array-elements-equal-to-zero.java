class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                if(process(nums, i, -1)) cnt++;  // Left
                if(process(nums, i, 1)) cnt++;   // Right
            }
        }
        return cnt;
    }
    boolean process(int[] nums, int s, int dir){
        int[] arr = nums.clone();
        int curr = s;
        int d = dir;
        while(curr<arr.length && curr>=0){
            if(arr[curr]==0){
                curr+=d;
            }
            else{
                arr[curr]--;
                d=-d;
                curr+=d;
            }
        }
        for(int num: arr){
            if(num!=0) return false;
        }
        return true;
    }
}