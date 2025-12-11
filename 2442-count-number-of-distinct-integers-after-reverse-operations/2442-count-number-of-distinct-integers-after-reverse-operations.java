class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
            set.add(reverse(num));
        }
        return set.size();
    }
    int reverse(int num){
        String s = Integer.toString(num);
        String rev = new StringBuilder(s).reverse().toString();
        return Integer.parseInt(rev);
    }
}