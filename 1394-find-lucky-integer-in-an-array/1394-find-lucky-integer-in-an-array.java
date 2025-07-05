class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans=-1;
        for(int num: arr) map.put(num, map.getOrDefault(num,0)+1);
        for(int key : map.keySet()){
            if(key==map.get(key)) ans = Math.max(ans,key);
        }
        return ans;
    }
}