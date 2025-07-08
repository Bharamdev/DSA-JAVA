class Solution {
    public int minimumOperations(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // for(int num:nums){
        //     if(num>0) set.add(num);
        // }
        // return set.size();
        int[] arr = new int[101];
        int cnt=0;
        for(int num:nums){
            arr[num]++;
            if(arr[num]==1 && num>0) cnt++;
        }
        return cnt;
    }
}