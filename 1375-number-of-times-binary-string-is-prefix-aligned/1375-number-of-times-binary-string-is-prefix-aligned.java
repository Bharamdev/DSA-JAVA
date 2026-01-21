class Solution {
    public int numTimesAllBlue(int[] flips) {
        int count=0;
        int flip=0;
        int max=0;
        for(int f: flips){
            max = Math.max(max, f);
            flip++;
            if(max==flip) count+=1;
        }
        return count;
    }
}