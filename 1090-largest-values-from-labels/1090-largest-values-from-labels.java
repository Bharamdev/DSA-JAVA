class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int sum=0;
        int n=values.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=values[i];
            arr[i][1]=labels[i];
        }
        Arrays.sort(arr,(a,b) -> b[0]-a[0]);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(numWanted==0) break;
            map.put(arr[i][1],map.getOrDefault(arr[i][1],0)+1);
            if(map.get(arr[i][1])>useLimit) continue;
            sum+=arr[i][0];
            numWanted--;
        }
        return sum;
    }
}