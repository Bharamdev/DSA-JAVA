class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length, m=grid[0].length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                set.add(grid[r][c]);
                for(int k=1; r+k*2<n && c-k>=0 && c+k<m; k++){
                    int sum=0;
                    for(int i=0;i<k;i++){
                        sum+=grid[r+i][c+i];
                    }
                    for(int i=0;i<k;i++) sum+=grid[r+i+k][c+k-i];
                    for(int i=0;i<k;i++) sum+=grid[r+2*k-i][c-i];
                    for(int i=0;i<k;i++) sum+=grid[r+k-i][c-k+i];
                    set.add(sum);
                }
            }
        }
        List<Integer> arr = new ArrayList<>(set);
        Collections.reverse(arr);
        int size = Math.min(3, arr.size());
        int[] ans = new int[size];
        for(int i=0;i<size;i++) ans[i] = arr.get(i);
        return ans;
    }
}