class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalApples=0;
        for(int a: apple) totalApples+=a;
        int n = capacity.length;
        for(int i=n-1;i>=0;i--){
            totalApples-=capacity[i];
            if(totalApples<=0) return n-i;
        }
        return n;
    }
}