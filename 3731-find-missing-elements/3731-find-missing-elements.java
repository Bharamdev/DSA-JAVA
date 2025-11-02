class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=101, max=-1;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(num<min) min=num;
            if(num>max) max=num;
            set.add(num);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}