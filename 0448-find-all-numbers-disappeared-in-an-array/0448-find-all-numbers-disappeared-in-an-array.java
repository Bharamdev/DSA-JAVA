class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int i=0;
        List<Integer> ans = new ArrayList<>();
        while(i<n){
            if(nums[i] != nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            else{
                i++;
            }
        }
        for(int j=0;j<n;j++){
            if(nums[j] != j+1){
                ans.add(j+1);
            }
        }
        return ans;
    }
}