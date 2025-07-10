class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer,Integer> map= new TreeMap<>();
        int n=nums.length;
        if(n%k!=0) return false;
        for(int num: nums) map.put(num,map.getOrDefault(num,0)+1);
        while(map.size()>0){
            int min = map.firstKey();
            int freq = map.get(min);
            for(int i=min;i<min+k;i++){
                if(map.getOrDefault(i,0)<freq) return false;
                map.put(i,map.get(i)-1);
                if(map.get(i)==0) map.remove(i);
            }
        }
        return true;
    }
}