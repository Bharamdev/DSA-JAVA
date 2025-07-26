class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            if(num%2==0) map.put(num, map.getOrDefault(num,0)+1);
        }
        int res=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(freq>max || (freq==max && key<res)){
                max=freq;
                res=key;
            }
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }
}