class Solution {
    public int minNumberOperations(int[] target) {
        int cnt=target[0];
        for(int i=1;i<target.length;i++){
            if(target[i]>target[i-1]) cnt+=(target[i]-target[i-1]);
        }
        return cnt;
    }
}