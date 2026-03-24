class Solution {
    public int maxOperations(int[] nums, int k) {
        if(nums.length<=1){
            return 0;
        }
        Arrays.sort(nums);
        int j = nums.length-1;
        int i=0;
        int c = 0;
        while(j>i){
            int sum = nums[i] + nums[j];
            if(sum == k){
                //value is exact, move both inward, no bias
                i++;j--;
                c++;
            }
            if(sum<k){ //value too low, increase 'i' pointer moving it towards a higher value;
                i++;
            }else if(sum>k){ //value too high, decrease 'j' pointer moving it towards a lower value;
                j--;
            }
        }
        return c;
    }
}