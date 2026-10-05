class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int maxCount=0;
        int temp=1;
        int i=0;
        if(nums.length==0){
            return 0;
        }else if(nums.length==1){
            return 1;
        }
        while(i<nums.length-1){
            if(nums[i]+1 == nums[i+1]){
                temp+=1;
                i++;
            }else if(nums[i]==nums[i+1]){
                i++;
            }else{ //i.e nums[i+1] > nums[i]
                temp=1;
                i++;
            }
            maxCount = Math.max(maxCount, temp);
        }
        return maxCount;
    }
}