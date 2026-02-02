class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        long result = Long.MAX_VALUE,windowSum = 0L;
        int n = nums.length;
        TreeSet<Integer> use = new TreeSet<>((a,b)->nums[a]==nums[b]?a-b:nums[a]-nums[b]);
        TreeSet<Integer> wait = new TreeSet<>((a,b)->nums[a]==nums[b]?a-b:nums[a]-nums[b]);
        for(int i=1;i<=dist+1;i++){
            use.add(i);
            windowSum += nums[i];
        }
        while(use.size()>k-1){
            int i = use.pollLast();
            windowSum -= nums[i];
            wait.add(i);
        }
        result = Math.min(result,windowSum);
        for(int i=1;i+dist+1<n;i++){
            wait.add(i+dist+1);
            if(use.contains(i)){
                windowSum -= nums[i];
                use.remove(i);
                int j = wait.pollFirst();
                windowSum += nums[j];
                use.add(j);
            }
            else{
                wait.remove(i);
                int j1 = wait.first(), j2 = use.last();
                if(nums[j1]<nums[j2]){
                    windowSum -= nums[j2];
                    use.remove(j2);
                    wait.add(j2);
                    windowSum += nums[j1];
                    use.add(j1);
                    wait.remove(j1);
                }
            }
            result = Math.min(result,windowSum);
        }
        return result+nums[0];
    }
}