class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //can be between 1 and max(piles);
        int l = 1;
        //find max;
        int r = 0;
        for(int i=0; i<piles.length; i++){
            r = Math.max(piles[i],r);
        }

        while(l<r){
            int mid = l + (r - l)/2;
            if(checker(piles,h,mid)){
                //maybe go slower, move towards speed being 1;
                r = mid;
            }else{
                //if false, too fast, mowards speed being max(piles)
                l = mid+1;
            }
        }
        return l;

    }
    public boolean checker(int[] piles, int h, int k){
        int hours=0;
        for(int i=0; i<piles.length; i++){
            hours = hours + (piles[i] + k - 1)/k; //do this to instead of ceil to not lose round off value
        }
        if(hours<=h){
            return true;
        }
        return false;
    }
}