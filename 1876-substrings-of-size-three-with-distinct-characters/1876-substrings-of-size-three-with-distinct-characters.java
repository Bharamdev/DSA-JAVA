class Solution {
    public int countGoodSubstrings(String s) {
        int n=s.length();
        if(n<3) return 0;
        int cnt=0;
        // for(int i=0;i<n-2;i++){
        //     HashMap<Character,Integer> map = new HashMap<>();
        //     map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        //     map.put(s.charAt(i+1),map.getOrDefault(s.charAt(i+1),0)+1);
        //     map.put(s.charAt(i+2),map.getOrDefault(s.charAt(i+2),0)+1);
        //     if(map.size()==3) cnt++;
        // }
        char[] arr = s.toCharArray();
        for(int i=0;i<n-2;i++){
            if(arr[i]!=arr[i+1] && arr[i+1]!=arr[i+2] && arr[i]!=arr[i+2]) cnt++;
        }
        return cnt;
    }
}