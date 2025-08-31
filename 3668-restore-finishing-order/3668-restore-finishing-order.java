class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> set = new HashSet<>();
        for(int x: friends) set.add(x);
        int idx=0;
        int[] arr = new int[friends.length];
        for(int o : order){
            if(set.contains(o)) arr[idx++]=o;
        }
        return arr;
    }
}