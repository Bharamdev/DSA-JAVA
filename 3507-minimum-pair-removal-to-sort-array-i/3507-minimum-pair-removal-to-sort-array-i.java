class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num: nums) list.add(num);
        int op=0;
        while(!sorted(list)){
            int minSum = Integer.MAX_VALUE;
            int idx=0;
            for(int i=0;i<list.size()-1;i++){
                int sum = list.get(i)+list.get(i+1);
                if(sum<minSum){
                    minSum=sum;
                    idx=i;
                }
            }
            list.set(idx,minSum);
            list.remove(idx+1);
            op++;
        }
        return op;
    }
    boolean sorted(List<Integer> list){
        int n = list.size();
        for(int i=0;i<n-1;i++){
            if(list.get(i)>list.get(i+1)) return false;
        }
        return true;
    }
}