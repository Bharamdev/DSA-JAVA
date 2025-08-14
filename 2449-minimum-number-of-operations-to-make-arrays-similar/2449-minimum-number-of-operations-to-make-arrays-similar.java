class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        ArrayList<Integer> numsEven = new ArrayList<>();
        ArrayList<Integer> numsOdd = new ArrayList<>();
        ArrayList<Integer> targetEven = new ArrayList<>();
        ArrayList<Integer> targetOdd = new ArrayList<>();
        long diff = 0;
        for(int num: nums){
            if(num%2==0) numsEven.add(num);
            else numsOdd.add(num);
        }
        for(int num: target){
            if(num%2==0) targetEven.add(num);
            else targetOdd.add(num);
        }
        Collections.sort(numsEven);
        Collections.sort(numsOdd);
        Collections.sort(targetEven);
        Collections.sort(targetOdd);
        for(int i=0;i<numsEven.size();i++){
            if(numsEven.get(i) > targetEven.get(i)){
                diff += (numsEven.get(i) - targetEven.get(i))/2;
            }
        }
        for(int i=0;i<numsOdd.size();i++){
            if(numsOdd.get(i) > targetOdd.get(i)){
                diff += (numsOdd.get(i) - targetOdd.get(i))/2;
            }
        }
        return diff;
    }
}