class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]<pivot){
                less.add(nums[i]);
            }
            else if(nums[i]==pivot){
                equal.add(nums[i]);
            }
            else{
                greater.add(nums[i]);
            }
        }
       
       int index=0; 
       for(int num: less){
        nums[index++]= num;
       }
       for(int num: equal){
        nums[index++]= num;
       }
       for(int num: greater){
        nums[index++]= num;
       }
        return nums;
    }
}