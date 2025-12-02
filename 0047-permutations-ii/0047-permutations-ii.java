class Solution {
    boolean[] vis;
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        vis = new boolean[n];
        backtrack(0, nums);
        return ans;
    }
    void backtrack(int idx, int[] nums){
        if(idx==n){
            ans.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(vis[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !vis[i-1]) continue;
            vis[i]=true;
            list.add(nums[i]);
            backtrack(idx+1,nums);
            list.remove(list.size()-1);
            vis[i]=false;
        }
    }
}