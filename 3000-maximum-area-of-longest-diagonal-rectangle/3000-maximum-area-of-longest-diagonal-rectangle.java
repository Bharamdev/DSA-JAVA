class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max=0;
        double longest = 0;
        for(int[] dimension: dimensions){
            int a = dimension[0];
            int b = dimension[1];
            double dia = Math.sqrt(a*a + b*b);
            int area = a*b;
            if(dia>longest){
                longest=dia;
                max=area;
            }
            if(dia==longest && area>max) max=area;
        }
        return max;
    }
}