class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        int right=n-1, left =0;
        while(right-left+1>k){
            if(Math.abs(arr[left]-x) <= Math.abs(arr[right]-x)) right--;
            else left++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=left;i<=right;i++) ans.add(arr[i]);
        return ans;

    }
}