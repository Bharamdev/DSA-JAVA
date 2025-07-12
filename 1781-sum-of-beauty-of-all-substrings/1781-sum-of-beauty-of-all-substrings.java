class Solution {
    public int beautySum(String s) {
        // Map<Character,Integer> map = new HashMap<>();
        // int cnt=0;
        // for(int i=0;i<s.length();i++){
        //     Map<Character,Integer> map = new HashMap<>();
        //     for(int j=i;j<s.length();j++){
        //         char ch = s.charAt(j);
        //         map.put(ch,map.getOrDefault(ch,0)+1);
        //         int min=501,max=0;
        //         for(int freq: map.values()){
        //             max=Math.max(max,freq);
        //             min = Math.min(min,freq);
        //         }
        //         cnt+=max-min;
        //     }
        // }

        // Optimize
         int cnt=0;
        for(int i=0;i<s.length();i++){
            int[] map= new int[26];
            for(int j=i;j<s.length();j++){
                char ch = s.charAt(j);
                map[ch-'a']++;
                int min=501,max=0;
                for(int freq: map){
                    if(freq>0){
                        max=Math.max(max,freq);
                        min = Math.min(min,freq);
                    }
                }
                cnt+=max-min;
            }
        }
        return cnt;
    }
}