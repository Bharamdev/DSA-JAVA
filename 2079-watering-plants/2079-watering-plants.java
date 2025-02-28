class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps=0, check=capacity;
        if(plants.length==1 && capacity>plants[0]) return 1;
        // else return -1;
        for(int i=0; i<plants.length; i++){
            if(check >= plants[i]){
                steps++;
                check -= plants[i];
            }
            else{
                steps+= i+i+1;
                check= capacity-plants[i];
            }
            
        }
        return steps;
    }
}