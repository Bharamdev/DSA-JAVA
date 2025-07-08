class Solution {
    public int distributeCandies(int[] candyType) {
        int n=candyType.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num: candyType) set.add(num);
        int size= set.size();
        if(size>=n/2) return n/2;
        return size;
    }
}