class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();
        int left=0, idx=0, maxlen=0;
        for(int i=0;i<arr.length;i++){
            while(!maxDq.isEmpty() && arr[maxDq.peekLast()]<arr[i]){
                maxDq.pollLast();
            }
            maxDq.addLast(i);
            while(!minDq.isEmpty() && arr[minDq.peekLast()]>arr[i]){
                minDq.pollLast();
            }
            minDq.addLast(i);
            while(arr[maxDq.peekFirst()] - arr[minDq.peekFirst()] > x){
                left++;
                if(maxDq.peekFirst() < left) maxDq.pollFirst();
                if(minDq.peekFirst() < left) minDq.pollFirst();
            }
            int len = i-left+1;
            if(len>maxlen){
                maxlen=len;
                idx=left;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<maxlen;i++){
            ans.add(arr[i+idx]);
        }
        return ans;
    }
}