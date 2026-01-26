class Solution {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    static boolean[] used;
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        int n = arr.length;
        ans.clear();
        used = new boolean[n];
        permutations(new ArrayList<>(), arr);
        return ans;
    }
    static void permutations(ArrayList<Integer> list, int[] arr){
        if(list.size()==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!used[i]){
                list.add(arr[i]);
                used[i]=true;
                permutations(list,arr);
                list.remove(list.size()-1);
                used[i]=false;
            }
        }
    }
};