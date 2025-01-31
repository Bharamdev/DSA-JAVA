class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // for(int i=1; i<nums.length; i++){
        //     if(nums[i]==nums[i-1]){
        //         return true;
        //     }
        // }
        // return false;
        HashSet<Integer> arr= new HashSet<>();
       
        for(int i=0; i<nums.length; i++){
            if(arr.contains(nums[i])) return true;
            arr.add(nums[i]);
           
        }
        return false;
        
    }
}