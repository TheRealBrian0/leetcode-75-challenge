import java.util.OptionalInt;
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> val = new ArrayList<>();
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }
        for(int i=0; i<candies.length; i++){
            if(candies[i]+extraCandies >= maxCandies){
                val.add(true);
            }else{
                val.add(false);
            }
        }
        return val;
    }
}