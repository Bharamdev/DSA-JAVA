class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        final int MOD = 1_000_000_007;
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                l.add(sum);
            }
        }
        Collections.sort(l);
        long res=0;
        for(int i=left-1;i<right;i++){
            res= (res+l.get(i))%MOD;
        }
        return (int)res;
    }
}