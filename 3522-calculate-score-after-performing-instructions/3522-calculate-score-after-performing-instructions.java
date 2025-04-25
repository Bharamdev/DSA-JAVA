class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        int n=values.length;
        int i=0;
        long score=0;
        HashSet<Integer> set = new HashSet<>();
        // boolean[] check = new boolean[n];
        while((i<n && i>=0) && !set.contains(i)){
            set.add(i);
            // check[i]=true;
            // if() return score;
            if(instructions[i].equals("add")){
                score+= values[i];
                i++;
            }
            else{
                i+=values[i];
            }
        }
        return score;
    }
}