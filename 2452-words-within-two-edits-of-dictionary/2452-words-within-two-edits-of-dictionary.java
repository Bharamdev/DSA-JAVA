class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        for(String query: queries){
            for(String dict: dictionary){
                int diff=0;
                for(int i=0;i<query.length();i++){
                    if(query.charAt(i)!=dict.charAt(i)) diff++;
                    if(diff>2) break;
                }
                if(diff<=2) {
                    list.add(query);
                    break;
                }
            }
        }
        return list;
    }
}