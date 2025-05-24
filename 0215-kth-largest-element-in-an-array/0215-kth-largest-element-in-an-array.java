class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n= nums.length;
        int start=0, end=n-1;
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums[k-1];
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int num:nums){
        //     pq.offer(num);
        //     if(pq.size()>k) pq.poll();
        // }
        // return pq.peek();
    }
}