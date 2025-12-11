class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for(int[] r: roads){
            degree[r[0]]++;
            degree[r[1]]++;
        }
        Integer[] cities = new Integer[n];
        for(int i=0;i<n;i++) cities[i]=i;
        Arrays.sort(cities, (a,b) -> degree[a]-degree[b]);
        int[] value = new int[n];
        int val=1;
        for(int c: cities) value[c]=val++;
        long sum=0;
        for(int[] r: roads) sum+=value[r[0]] + value[r[1]];
        return sum;
    }
}