class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n=nums.length;
        if(n==0) return res;
        int start=nums[0];
        for(int i=1;i<=n;i++){
            if(i==n || nums[i] != nums[i-1]+1){
                if(start==nums[i-1]) res.add(start+"");
                else{
                    res.add(start+"->"+nums[i-1]);
                }
                if(i<n) start=nums[i];
            }
        }
        return res;
    }
}