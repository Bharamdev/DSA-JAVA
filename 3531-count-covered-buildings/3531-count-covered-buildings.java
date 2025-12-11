class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int cnt=0;
        Map<Integer,Integer> minx = new HashMap<>();
        Map<Integer,Integer> maxx = new HashMap<>();
        Map<Integer,Integer> miny = new HashMap<>(); 
        Map<Integer,Integer> maxy = new HashMap<>();
        for(int[] b: buildings){
            int x=b[0], y=b[1];
            minx.put(y, Math.min(minx.getOrDefault(y, Integer.MAX_VALUE), x));
            maxx.put(y, Math.max(maxx.getOrDefault(y, Integer.MIN_VALUE), x));
            miny.put(x, Math.min(miny.getOrDefault(x, Integer.MAX_VALUE), y));
            maxy.put(x, Math.max(maxy.getOrDefault(x, Integer.MIN_VALUE), y));
        }
        for(int[] b: buildings){
            int x=b[0], y=b[1];
            if(y>miny.get(x) && y<maxy.get(x) && x>minx.get(y) && x<maxx.get(y)) cnt++;
        }
        return cnt;
    }
}