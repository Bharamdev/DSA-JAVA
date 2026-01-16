class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] h = new int[hFences.length+2];
        int[] v = new int[vFences.length+2];
        // Add boundary fences
        h[0]=1;
        v[0]=1;
        h[h.length-1]=m;
        v[v.length-1]=n;
        for(int i=0;i<hFences.length;i++) h[i+1] = hFences[i];
        for(int i=0;i<vFences.length;i++) v[i+1] = vFences[i];
        Arrays.sort(v);
        Arrays.sort(h);
        Set<Integer> hDiff = new HashSet<>();
        for(int i=0;i<h.length;i++){
            for(int j=i+1;j<h.length;j++){
                hDiff.add(h[j]-h[i]);
            }
        }
        long max=-1;
        for(int i=0;i<v.length;i++){
            for(int j=i+1;j<v.length;j++){
                int diff = v[j]-v[i];
                if(hDiff.contains(diff)){
                    max = Math.max(max, (long)diff*diff);
                }
            }
        }
        int mod = (int)1e9+7;
        return  (int)(max%mod);
    }
}