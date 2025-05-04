class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int[] d: dominoes){
            int max = Math.max(d[0],d[1]);
            int min = Math.min(d[0],d[1]);
            String str = min + " "+ max;
            map.put(str,map.getOrDefault(str,0)+1);
        }
        int cnt=0;
        for(int val: map.values()){
            cnt+= val*(val-1)/2; 
        }
        return cnt;
    }
}