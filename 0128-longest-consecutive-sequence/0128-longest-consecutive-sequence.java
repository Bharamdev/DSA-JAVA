class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        int longest=0;
        for(int num: set){
            if(!set.contains(num-1)){
                int cnt=1;
                int currnum=num;
                while(set.contains(currnum+1)){
                    cnt++;
                    currnum++;
                }
                longest = Math.max(longest,cnt);
            }
        }
        return longest;
    }
}