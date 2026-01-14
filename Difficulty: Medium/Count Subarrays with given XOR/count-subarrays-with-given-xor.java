class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        int xor=0, cnt=0;
        map.put(0,1);
        for(int a: arr){
            xor^=a;
            int need = xor^k;
            if(map.containsKey(need)){
                cnt+=map.get(need);
            }
            map.put(xor, map.getOrDefault(xor,0)+1);
        }
        return cnt;
    }
}