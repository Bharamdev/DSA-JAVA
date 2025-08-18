class Solution {
    public int minimumSum(int n, int k) {
        HashSet<Integer> set = new HashSet<>();
        int num=1;
        while(true){
            if(set.size()==n) break;
            int rem = k-num;
            if(!set.contains(rem)){
                set.add(num);
            }
            num++;
        }
        int sum=0;
        for(int x: set) sum+=x;
        return sum;
    }
}