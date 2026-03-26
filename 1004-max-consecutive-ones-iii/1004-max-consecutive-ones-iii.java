class Solution {
    public int longestOnes(int[] nums, int k) {
        int j = 0;
        int i;
        for(i=0; i<nums.length; i++){
            if(nums[i]==0){
                k--;
            }
            if(k<0){
                if(nums[j]==0){
                    //only refund k if we meet a 0
                    k++;
                }
                j++;
            }
        }
        return i - j;
    }
}