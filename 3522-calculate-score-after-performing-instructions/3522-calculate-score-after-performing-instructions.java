class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        int i=0;
        long score=0;
        boolean[] check = new boolean[values.length];
        while((i<values.length && i>=0) && !check[i]){
            check[i]=true;
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