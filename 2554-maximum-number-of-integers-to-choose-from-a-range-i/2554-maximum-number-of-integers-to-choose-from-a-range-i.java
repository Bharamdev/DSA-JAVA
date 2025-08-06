class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for(int num: banned) set.add(num);
        int cnt=0;
        long sum=0;
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                sum+=i;
                if(sum>maxSum) break;
                cnt++;
            }
        }
        return cnt;
    }
}