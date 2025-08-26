class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
        List<Boolean> res = new ArrayList<>();
        for(int can: candies) max=Math.max(max,can);
        for(int i=0;i<candies.length;i++){
            int num=candies[i];
            if((num+extraCandies) >= max) res.add(true);
            else res.add(false);
        }
        return res;
    }
}