class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int cnt=0;
        for(int i=0;i<energy.length;i++){
            if(energy[i]>=initialEnergy){
                while(initialEnergy<=energy[i]){
                    initialEnergy++;
                    cnt++;
                }
            }
            initialEnergy-=energy[i];
        }
        for(int i=0;i<experience.length;i++){
            if(experience[i]>=initialExperience){
                while(initialExperience<=experience[i]){
                    initialExperience++;
                    cnt++;
                }
            }
            initialExperience+=experience[i];
        }
        return cnt;
    }
}