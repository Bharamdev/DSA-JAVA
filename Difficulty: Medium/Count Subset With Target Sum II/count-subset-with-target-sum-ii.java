class Solution {
    Map<String,Integer> memo;
    public int countSubset(int[] arr, int k) {
        // code here
        memo = new HashMap<>();
        int psum = 0, nsum = 0;
        for (int num : arr) {
            if (num > 0) psum += num;
            else nsum += num;
        }

        if (k > psum || k < nsum) return 0;
        return solve(0,arr,k);
    }
    int solve(int idx, int[] arr, int k){
        if(idx==arr.length){
            if(k==0) return 1;
            return 0;
        }
        String key = idx+"-"+k;
        if(memo.containsKey(key)) return memo.get(key); 
        // Take
        int take = solve(idx+1, arr,k-arr[idx]);
        // Not take
        int notTake = solve(idx+1, arr, k);
        memo.put(key, take+notTake);
        return take+notTake;
    }
}
