class Solution {
    public int earliestTime(int[][] tasks) {
        int min = Integer.MAX_VALUE;
        for(int[] task : tasks){
            min = Math.min(min, task[0]+task[1]);
        }
        return min;
    }
}