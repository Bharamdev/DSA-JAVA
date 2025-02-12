class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n= grid.length;
        int[] arr= new int[(n*n)+1];
        int[] ans = new int[2];
        arr[0]=1;
        for(int[] grids: grid){
            for(int i=0; i<grids.length; i++){
                arr[grids[i]]++;
               
            }
        }
        for(int i=1; i<arr.length; i++){
             if(arr[i]==2){
                    ans[0]=i;
                }
                if(arr[i]==0){
                    ans[1]=i;
                }
                
        }
        return ans;
    }
}