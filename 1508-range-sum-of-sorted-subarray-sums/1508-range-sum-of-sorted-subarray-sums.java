class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // int[] res = new int[n*(n+1)/2];
        // int rightsum=0,leftsum=0,index=0;
        // for(int i=0;i<n;i++){
        //     rightsum+=nums[i];
        // }
        // for(int i=0;i<n;i++){
        //     leftsum+=nums[i];
        //     res[index++]=rightsum;
        //     res[index++]=nums[i];
        //     res[index++]=leftsum;
        //     rightsum-=nums[i];
        // }
        // Arrays.sort(res);
        // int ans=0;
        // for(int i=left;i<=right;i++){
        //     ans+=res[i];
        // }
        // return ans;
        int MOD = 1_000_000_007;
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