class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mention = new int[numberOfUsers];
        int[] offline = new int[numberOfUsers];
        Collections.sort(events, (a,b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if(t1!=t2) return t1-t2;
            if(a.get(0).equals("OFFLINE") && b.get(0).equals("MESSAGE")) return -1;
            if(a.get(0).equals("MESSAGE") && b.get(0).equals("OFFLINE")) return 1;
            return 0;
        });
        for(List<String> e: events){
            String type = e.get(0);
            int time = Integer.parseInt(e.get(1));
            String data = e.get(2);
            for(int i=0;i<numberOfUsers;i++){
                if(offline[i]!=0 && time>=offline[i]){
                    offline[i]=0;   // make user online
                }
            }
            if(type.equals("OFFLINE")){
                int user = Integer.parseInt(data);
                offline[user] = time+60;
            }
            else{
                if(data.equals("ALL")){
                    for(int i=0;i<numberOfUsers;i++) mention[i]++;
                }
                else if(data.equals("HERE")){
                    for(int i=0;i<numberOfUsers;i++){
                        if(offline[i]==0) mention[i]++;
                    }
                }
                else{
                    String[] ids = data.split(" ");
                    for(String str: ids){
                        int user = Integer.parseInt(str.substring(2));
                        mention[user]++;
                    }
                }
            }
        }
        return mention;
    }
}