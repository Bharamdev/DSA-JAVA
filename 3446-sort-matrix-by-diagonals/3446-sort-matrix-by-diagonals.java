class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int key=i-j;
                // Key >= 0 --> decreasing Order
                if(key>=0){
                    map.putIfAbsent(key, new PriorityQueue<>(Collections.reverseOrder()));
                }
                //  key<0 --> increasing order
                else{
                    map.putIfAbsent(key, new PriorityQueue<>());
                }
                map.get(key).offer(grid[i][j]);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int key=i-j;
                grid[i][j] = map.get(key).poll();
            }
        }
        return grid;
    }
}