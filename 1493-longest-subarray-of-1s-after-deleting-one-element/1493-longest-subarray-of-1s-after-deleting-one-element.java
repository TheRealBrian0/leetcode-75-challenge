class Solution {
    public int longestSubarray(int[] nums) {
        int i;
        int j = 0;
        int k = 1; // Our budget of allowed zeros
        
        for (i = 0; i < nums.length; i++) {
            // If we encounter a 0, we "spend" it from our budget
            if (nums[i] == 0) {
                k--;
            }
            
            // If budget is negative, we've hit too many zeros
            if (k < 0) {
                // If the element leaving the window (at j) is a 0, 
                // we get that point back in our budget
                if (nums[j] == 0) {
                    k++;
                }
                j++; // Slide the window tail forward
            }
        }
        
        // i ends at nums.length, j is the start of our max-sized window.
        // We subtract 1 because one element MUST be deleted.
        return i - j - 1;
    }
}