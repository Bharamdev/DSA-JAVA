class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];
        int idx=0;
        for(int num: nums){
            if((num&1)==0) res[idx++]=-1;
            else{
                for(int i=0;i<32;i++){
                    if((num & (1<<i)) > 0) continue;
                    int x = (num ^ (1<<(i-1)));
                    res[idx++]=x;
                    break;
                }
            }
        }
        return res;
    }
}