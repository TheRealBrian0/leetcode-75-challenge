class Solution {
    public int pivotIndex(int[] nums) {
        //find total sum
        int total=0;
        for(int n:nums){
            total+=n;
        }
        //iterate
        int left = 0;
        int right;
        for(int i=0; i<nums.length;i++){
            //calc right side
            right = total - left - nums[i];
            if(left == right){
                return i;
            }
            //update left with next variable
            left = left + nums[i];
        }
        return -1;
    }
}