class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // int max= Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        int max= arrays.get(0).get(arrays.get(0).size()-1);
        int min= arrays.get(0).get(0);
        int ans=-1;
        for(List<Integer> arr: arrays){
            
            ans = Math.max(ans,Math.abs(max-arr.get(0)));
            ans= Math.max(ans, Math.abs(arr.get(arr.size()-1) - min));
                
            max= Math.max(max, arr.get(arr.size()-1));
            min= Math.min(min, arr.get(0));
            
        }
        return ans;
    }
}