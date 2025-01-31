class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int left=0,right=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> arr = new HashSet<>();
        while(left<nums1.length && right<nums2.length){
            if(nums1[left]==nums2[right] ){
                arr.add(nums1[left]);
                left++;
                right++;
            }
            else if(nums1[left]>nums2[right]){
                right++;
            }
            else{
                left++;
            }
        }
        return arr.stream().mapToInt(i -> i).toArray();
    }
}