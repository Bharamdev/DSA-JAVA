class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] p: paths){
            adj.get(p[0]-1).add(p[1]-1);
            adj.get(p[1]-1).add(p[0]-1);
        }
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            boolean[] used = new boolean[5];
            for(int it: adj.get(i)){
                if(answer[it]!=0){
                    used[answer[it]]=true;
                }
            }
            for(int f=1;f<=4;f++){
                if(!used[f]){
                    answer[i]=f;
                    break;
                }
            }
        }
        return answer;
    }
}