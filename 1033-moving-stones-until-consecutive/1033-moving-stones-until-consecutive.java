class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = {a,b,c};
        Arrays.sort(arr);
        int min=arr[0];
        int max=arr[2];
        int[] ans = new int[2];
        ans[1] = max-min-2;
        int right = max-arr[1];
        int left = arr[1]-min;
        if(left==1 && right==1) ans[0]=0;
        else if(left<=2 || right<=2){
            ans[0]=1;
        }
        else{
            ans[0]=2;
        }
        return ans;
    }
}