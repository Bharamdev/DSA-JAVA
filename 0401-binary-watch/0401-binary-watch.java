class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for(int hr=0;hr<12;hr++){
            for(int min=0;min<60;min++){
                if(Integer.bitCount(hr) + Integer.bitCount(min)==turnedOn){
                    String time = hr + ":" + (min<10 ? "0"+min : min);
                    res.add(time);
                }
            }
        }
        return res;
    }
}