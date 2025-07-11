class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int start=nums[0];
        int n=nums.length;
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