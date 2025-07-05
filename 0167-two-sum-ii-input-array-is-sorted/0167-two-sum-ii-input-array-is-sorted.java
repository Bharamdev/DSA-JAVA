class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int n=numbers.length;
        int l=0,r=n-1;
        int sum=numbers[r]+numbers[l];
        while(r<n){
            if(sum<target){
                sum-=numbers[l];
                l++;
                sum+=numbers[l];
            }
            else if(sum>target){
                sum-=numbers[r];
                r--;
                sum+=numbers[r];
            }
            else{
                ans[0]=l+1;
                ans[1]=r+1;
                return ans;
            }
        }
        return ans;
    }
}