class Solution {
    public int totalFruit(int[] fruits) {
        int n= fruits.length;
        int s=0,ans=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e=0; e<n; e++){
            map.put(fruits[e], map.getOrDefault(fruits[e],0)+1);
            while(map.size()>2){
                map.put(fruits[s], map.getOrDefault(fruits[s],0)-1);
                if(map.get(fruits[s])==0){
                    map.remove(fruits[s]);
                }
                s++;
            }
            ans= Math.max(ans,e-s+1);
        }
        return ans;
    }
}