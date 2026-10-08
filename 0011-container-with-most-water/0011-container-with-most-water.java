class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxVal = 0;
        // if (height.length == 2) {
        //     return (Math.max(height[right], height[left]) - Math.min(height[right], height[left]))
        //             * Math.min(height[right], height[left]);
        // }
        while (left < right) {
            int curr = (Math.min(height[right], height[left])) * (right - left);
            // System.out.println(Math.min(height[right], height[left]) +" "+ (right - left));
            // System.out.println(height[left]+" "+height[right]+" "+curr+"\n");
            maxVal = Math.max(curr, maxVal);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxVal;
    }
}