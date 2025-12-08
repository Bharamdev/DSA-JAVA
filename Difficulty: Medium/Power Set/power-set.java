// User function Template for Java

class Solution {
    public List<String> AllPossibleStrings(String s) {
        // Code here
        List<String> res = new ArrayList<>();
        int n=s.length();
        int subsets = 1<<n;
        for(int num=1;num<subsets;num++){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                if((num&(1<<i))!=0) sb.append(s.charAt(i));
            }
            res.add(sb.toString());
        }
        Collections.sort(res);
        return res;
    }
}