class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int diff=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int bob: bobSizes){
            diff+=bob;
            map.put(bob,map.getOrDefault(bob,0)+1);
        }
        for(int alice: aliceSizes){
            diff-=alice;
        }
        diff/=2;
        int[] ans = new int[2];
        for(int i=0;i<aliceSizes.length;i++){
            if(map.containsKey(aliceSizes[i]+diff)){
                ans[0]=aliceSizes[i];
                ans[1]=aliceSizes[i]+diff;
                break;
            }
        }
        return ans;
    }
}