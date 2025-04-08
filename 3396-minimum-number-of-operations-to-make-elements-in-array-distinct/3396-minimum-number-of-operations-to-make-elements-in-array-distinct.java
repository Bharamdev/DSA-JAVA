class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int cnt=0;
        for(int num:nums) list.add(num);
        while(true){
            HashSet<Integer> set = new HashSet<>(list);
            if(set.size()==list.size()) return cnt;
            int min = Math.min(3,list.size());
            for(int i=0;i<min;i++){
                list.remove(0);
            }
            cnt++;
        }
        
    }
}