class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n= nums.length;
        int[] res= new int[n-k+1];
        // for(int i=0;i<n-k+1;i++){
        //     boolean isvalid = true;
        //     for(int j=i;j<k+i-1;j++){
        //         if(nums[j]+1 !=nums[j+1]){
        //             isvalid = false;
        //             res[i]=-1;
        //             break;
        //         }
        //     }
        //     if(isvalid) res[i]=nums[i+k-1];
        // }

        Arrays.fill(res,-1);
        int cnt=1;
        for(int i=0;i<n;i++){
            if( i>0 && nums[i] == nums[i-1]+1) cnt++;
            else cnt=1;
            if(cnt>=k) res[i-k+1]=nums[i];
        }
        return res;
    }
}