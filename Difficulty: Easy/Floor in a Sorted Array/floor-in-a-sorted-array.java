class Solution {

    static int findFloor(int[] arr, int x) {
        // write code here
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]>x) return i-1;
        }
        if(arr[arr.length-1]<=x) return arr.length-1;
        return -1;
    }
}
