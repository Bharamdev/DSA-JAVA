class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            List<Integer> ds = new ArrayList<>();
            if(i>0 && nums[i]==nums[i-1]) continue;
           int k= i+1;
           int l= nums.length-1;
            while(k<l){
            int sum = nums[i];
            sum+=nums[k];
            sum+=nums[l];
                if(sum<0){
                    k++;
                }
                else if(sum>0){
                    l--;
                }
                else{
                    ans.add(Arrays.asList(nums[i],nums[k],nums[l]));
                    k++;
                    l--;
                    while(k<l && nums[k]==nums[k-1]) k++;
                    while(k<l && nums[l] == nums[l+1]) l--;
                    
                }
            }
        }
        return ans;
    }
}