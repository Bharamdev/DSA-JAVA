class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int low=1, high=0, ans=0;
        for(int a: arr) high = Math.max(a,high);
        ans=high;
        while(low<=high){
            int mid = low + (high-low)/2;
            int hr=0;
            for(int a: arr){
                hr += (a+mid-1)/mid;
            }
            if(hr<=k){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}
