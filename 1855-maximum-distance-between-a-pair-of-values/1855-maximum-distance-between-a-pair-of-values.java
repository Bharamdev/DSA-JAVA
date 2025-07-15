class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        int res=0;
        int i=0,j=0;
        while(i<n1 && j<n2){
            if(nums2[j]>=nums1[i]){
                res=Math.max(res,j-i);
                j++;
            }
            else{
                i++;
            }
            
        }
        return res;
    }
}