class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n= nums.length;
        int[] res= new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            boolean isvalid = true;
            for(int j=i;j<k+i-1;j++){
                if(nums[j]+1 !=nums[j+1]){
                    isvalid = false;
                    res[i]=-1;
                    break;
                }
            }
            if(isvalid) res[i]=nums[i+k-1];
        }
        return res;
    }
}