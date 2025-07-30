class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int len=0,st=0;
        for(int end=0;end<nums.length;end++){
            while(!max.isEmpty() && nums[end]>max.peekLast()){
                max.pollLast();
            }
            max.offerLast(nums[end]);
            while(!min.isEmpty() && nums[end]<min.peekLast()){
                min.pollLast();
            }
            min.offerLast(nums[end]);
            while((max.peekFirst()-min.peekFirst())>limit){
                if(max.peekFirst()==nums[st]) max.pollFirst();
                if(min.peekFirst()==nums[st]) min.pollFirst();
                st++;
            }
            len=Math.max(len, end-st+1);
        }
        return len;
    }
}