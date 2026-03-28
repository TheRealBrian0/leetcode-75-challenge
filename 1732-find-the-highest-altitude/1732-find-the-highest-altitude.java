class Solution {
    public int largestAltitude(int[] gain) {
        int[] total = new int[gain.length+1];
        total[0]=0;
        int maxv = 0;
        for(int i=1; i<total.length; i++){
            total[i] = gain[i-1] + total[i-1] ;
            maxv = Math.max(maxv,total[i]);
        }
        
        //use only 2 variables for most efficient approach
        // int currentAltitude = 0; int maxAltitude = 0; // Start at 0 because the hiker starts at 0
        // for (int g : gain) {
        //     currentAltitude += g; // Update the current height
        //     maxAltitude = Math.max(maxAltitude, currentAltitude); // Is this the highest yet?
        // }

        return maxv;
    }
}