class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int neg=0;
        int min=Integer.MAX_VALUE;
        for(int[] mat: matrix){
            for(int num: mat){
                sum+=Math.abs(num);
                if(num<0) neg++;
                min = Math.min(min, Math.abs(num));
            }
        }
        if(neg%2!=0) sum-=2*min;
        return sum;
    }
}