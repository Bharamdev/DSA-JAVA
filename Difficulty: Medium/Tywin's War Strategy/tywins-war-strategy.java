class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        int n = arr.length;
        int required = (n+1)/2;
        int cnt=0;
        List<Integer> cost = new ArrayList<>();
        for(int num: arr){
            if(num%k==0) cnt++;
            else{
                int rem = num%k;
                cost.add(k-rem);
            }
        }
        if(cnt>=required) return 0;
        int needed = required-cnt;
        int total=0;
        Collections.sort(cost);
        for(int i=0;i<needed;i++) total+=cost.get(i);
        return total;
    }
}