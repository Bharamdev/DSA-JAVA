class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // ArrayList<Integer> arr = new ArrayList<>();
        int left=m-1;
        int right=n-1;
        int p = m+n-1;
        while(left>=0 && right>=0){
            if(nums1[left]>nums2[right]){
                nums1[p]=nums1[left];
                left--;
            }
            else{
               nums1[p]=nums2[right];
                right--;
            }
            p--;
        }
        while(right>=0){
           nums1[p] = nums2[right];
            right--;
            p--;
        }
        
    }
    
}