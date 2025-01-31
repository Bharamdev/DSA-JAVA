class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int left=0,right=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> arr = new ArrayList<>();
        while(left<nums1.length && right<nums2.length){
            if(nums1[left]==nums2[right] && !arr.contains(nums2[right])){
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
        int[] arr2 = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arr2[i] = arr.get(i);
        }
        return arr2;
    }
}