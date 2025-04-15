class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> str = new ArrayList<>();
        for(int i=0;i<words.size();i++){
            String[] addstr = words.get(i).split("\\"+separator);
            for(int j=0;j<addstr.length;j++){
                if(!addstr[j].isEmpty()) str.add(addstr[j]);
            }
        }
        return str;
    }
}