class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxSize=0;
        for(int i=1;i<=n;i++){
            int num=i,sum=0;
            while(num>0){
                sum += num%10;
                num=num/10;
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            maxSize = Math.max(maxSize,map.get(sum));
        }
        int cnt=0;
        for(int val: map.values()){
            if(val==maxSize) cnt++;
        }
        return cnt;
    }
}