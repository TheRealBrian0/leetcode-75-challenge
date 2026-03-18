class Solution {
    public boolean increasingTriplet(int[] nums) {
        int f=Integer.MAX_VALUE; int s=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(f>nums[i]){
                f=nums[i];
            }else{
                if(f<nums[i] && s>nums[i]){
                    s=nums[i];
                }else{
                    if(f< nums[i] && s<nums[i]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}