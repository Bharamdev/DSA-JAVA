class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.contains(part)) s = s.replaceAll(part,"");
        return s;
    }
}