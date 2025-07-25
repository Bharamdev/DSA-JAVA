class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int task:tasks) map.put(task, map.getOrDefault(task,0)+1);
        int cnt=0;
        for( int value: map.values()){
            if(value==1) return -1;
            if(value%3==0){
                cnt+=value/3;
            }
            else cnt+= value/3 +1;
        }
        return cnt;
        
    }
}