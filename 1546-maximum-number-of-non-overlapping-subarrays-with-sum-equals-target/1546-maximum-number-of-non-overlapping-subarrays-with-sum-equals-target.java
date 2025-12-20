class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        int cnt=0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int sum=0;
        for(int num: nums){
            sum+=num;
            int diff = sum-target;
            if(set.contains(diff)){
                cnt++;
                sum=0;
                set.clear();
                set.add(0);
            }
            else set.add(sum);
        }
        return cnt;
    }
}