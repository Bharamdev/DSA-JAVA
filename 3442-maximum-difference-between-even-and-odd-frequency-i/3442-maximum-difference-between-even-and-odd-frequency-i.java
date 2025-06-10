class Solution {
    public int maxDifference(String s) {
        int maxeven=-1,maxodd=-1,minodd=Integer.MAX_VALUE,mineven=Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i: map.values()){
            if(i%2!=0) {
                maxodd = Math.max(maxodd,i);
                minodd = Math.min(minodd,i);
            }
            else {
                maxeven = Math.max(maxeven,i);
                mineven = Math.min(mineven,i);
            }
        }
        return maxodd-mineven;

    }
}