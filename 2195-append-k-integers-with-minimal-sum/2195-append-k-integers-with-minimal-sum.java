class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        long sum=0;
        for(int num:nums){
            if(!set.contains(num) && num<=k){
                k++;
                sum+=num;
            }
            set.add(num);
        }
        long add = ((long)k*(k+1))/2;
        return add-sum;
    }
}