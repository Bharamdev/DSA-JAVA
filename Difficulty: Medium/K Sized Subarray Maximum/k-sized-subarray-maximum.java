class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]){
                dq.pollLast();
            }
            if(!dq.isEmpty() && dq.peekFirst()<=i-k) dq.pollFirst();
            dq.offerLast(i);
            if(i>=k-1) ans.add(arr[dq.peekFirst()]);
        }
        return ans;
    }
}