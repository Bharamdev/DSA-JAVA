class Solution {
    int[][] dp = new int[501][501];
    int n,m;
    int neg = (int)-1e7;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        n=nums1.length;
        m=nums2.length;
        for(int[] d: dp) Arrays.fill(d, Integer.MIN_VALUE);
        return solve(0,0,nums1,nums2);
    }
    int solve(int i, int j, int[] nums1, int[] nums2){
        if(i==n || j==m) return neg;
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int val = nums1[i]*nums2[j];
        int take = val + Math.max(0, solve(i + 1, j + 1, nums1, nums2));
        int skip1 = solve(i+1, j, nums1, nums2);
        int skip2 = solve(i, j+1, nums1, nums2);
        return dp[i][j] = Math.max(take, Math.max(skip1,skip2));
    }
}