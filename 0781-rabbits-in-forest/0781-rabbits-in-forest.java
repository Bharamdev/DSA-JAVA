class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x: answers){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        int total=0;
        for(int x: map.keySet()){
            int freq = map.get(x);
            int groupsize = x+1;    // x+1 --> group size (answers[i]  --> 
                                    //               other rabbits and +1 for itself)
            int groups = (freq+groupsize-1)/groupsize;  // Ceiling of freq/groupsize
            total += groups*groupsize;
        }
        return total;
    }
}