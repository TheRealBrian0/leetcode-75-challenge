class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //first calc just the sum
        double sum = 0;
        for(int i=0; i<k; i++){
            sum = sum + nums[i];
        }
        double maxv = sum;
        //activate sliding window
        for(int i=1; i<=nums.length-k; i++){
            // int j = i + k - 1;
            sum = sum - nums[i-1] + nums[i + k - 1];
            maxv = Math.max(maxv,sum);
        }
        return maxv/k;
    }
}