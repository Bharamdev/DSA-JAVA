class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int ans=Integer.MAX_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                ans = Math.min(ans, i-map.get(nums[i]));
            }
            int rev = reverse(nums[i]);
            map.put(rev, i);
        }
        return ans==Integer.MAX_VALUE ? -1: ans;
    }
    int reverse(int num){
        String s = new StringBuilder(Integer.toString(num)).reverse().toString();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') continue;
            else{
                s=s.substring(i);
                break;
            }
        }
        return Integer.parseInt(s);
    }
}