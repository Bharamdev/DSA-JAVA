class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        int cnt=0;
        int n=arr.length;
        int r=0,l=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r<n){
            map.put(arr[r], map.getOrDefault(arr[r],0)+1);
            while(map.size()>k){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])<=0) map.remove(arr[l]);
                l++;
            }
            cnt+= r-l+1;
            r++;
        }
        return cnt;
    }
}
