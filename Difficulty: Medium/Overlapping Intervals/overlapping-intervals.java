class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        Arrays.sort(arr, (a,b) -> a[0]-b[0] );
        ArrayList<int[]> res = new ArrayList<>();
        int[] start = arr[0];
        int n = arr.length;
        for(int i=1;i<n;i++){
            if(arr[i][0] <= start[1]){
                start[1] = Math.max(start[1], arr[i][1]);
            }
            else{
                res.add(start);
                start=arr[i];
            }
        }
        res.add(start);
        return res;
    }
}