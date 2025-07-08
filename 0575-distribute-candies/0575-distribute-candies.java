class Solution {
    public int distributeCandies(int[] candyType) {
        int n=candyType.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num: candyType) {
            if(set.size()==n/2) return n/2;
            set.add(num);
        }
        return set.size();
    }
}